package cn.wolfcode.wechat.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.TreeSet;

import cn.wolfcode.wechat.domain.Message;
import cn.wolfcode.wechat.service.IClientService;
import cn.wolfcode.wechat.service.IMessageService;
import cn.wolfcode.wechat.util.UserUtil;
import cn.wolfcode.wechat.vo.*;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wolfcode.wechat.util.SecurityUtil;

@Controller
public class WechatControllor {
	@Value("${wechat.token}")
	private String token;
	@Autowired
	private IMessageService messageService;
	@Autowired
	private IClientService clientService;
	@RequestMapping("index")
	@ResponseBody
	public String index()
	{
		return "hello";
	}

	@RequestMapping(value = "wechat",method = RequestMethod.GET)
	@ResponseBody
	/**
	 * signature	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
		timestamp	时间戳
		nonce	随机数
		echostr	随机字符串
	 * @return
	 */
	public String wechat( String signature,String timestamp,String nonce,String echostr){
		//1）将token、timestamp、nonce三个参数进行字典序排序
		TreeSet<String> set = new TreeSet<>();
		set.add(token);
		set.add(timestamp);
		set.add(nonce);		
		//2）将三个参数字符串拼接成一个字符串进行sha1加密
		StringBuilder sb = new StringBuilder();
		for (String str : set) {
			sb.append(str);
		}
		String ret = SecurityUtil.SHA1(sb.toString());
		//3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
		//ret和signature进行匹配，相等返回echostr接入成功，否则接入失败
		if (ret.equals(signature)) {
			return echostr;
		}
		return "success";
		/*TreeSet<String> set = new TreeSet();
		set.add(token);
		set.add(timestamp);
		set.add(nonce);
		StringBuilder stringBuilder = new StringBuilder();
		for (String ret:set)
		{
			stringBuilder.append(ret);

		}
		if(SecurityUtil.SHA1(stringBuilder.toString()).equals(echostr))
		{
			return echostr;
		}
		return null;*/
	}
	
	
/*	@RequestMapping(value = "wechat",method = RequestMethod.POST)
	@ResponseBody
	public MessageResponseVo wechat(@RequestBody MessageRequestVo requestVo){
		*//*MessageResponseVo responseVo = new MessageResponseVo();
		responseVo.setContent("好的！");
		responseVo.setCreateTime(new Date().getTime());
		responseVo.setFromUserName(requestVo.getToUserName());
		responseVo.setMsgType("text");
		responseVo.setToUserName(requestVo.getFromUserName());*//*
		
		return null;
	}*/
	@RequestMapping(value = "wechat",method = RequestMethod.POST)
	@ResponseBody
	public ResponseVo msg(@RequestBody RequestVo requestVo) throws Exception {
		UserUtil.setUser(requestVo.getFromUserName());
		Message message = new Message();
		message.setClientId(requestVo.getMsgId());
		message.setInputTime(new Date());
		message.setReceiveContent(requestVo.getContent());
		message.setType(this.getType(requestVo));
		ResponseVo vo=null;
		if("event".equals(requestVo.getMsgType())) {
			if("subscribe".equals(requestVo.getevent())) {
				vo.setContent("欢迎订阅");
				vo.setCreateTime(new Date().getTime());
				vo.setFromUserName(requestVo.getToUserName());
				vo.setToUserName(requestVo.getFromUserName());
				vo.setMsgType("text");
			}
		}
		if("text".equals(requestVo.getMsgType())) {

		}
		if("image".equals(requestVo.getMsgType())) {
			vo.setContent("图片");
			vo.setCreateTime(new Date().getTime());
			vo.setFromUserName(requestVo.getToUserName());
			vo.setToUserName(requestVo.getFromUserName());
			vo.setMsgType("text");
		}
		//图灵机器人的账号密匙
		String APIKEY = "e7a1447ed2182d57758ca845e5a0f36e";
		System.out.println(requestVo.getContent());
		String question = requestVo.getContent();//这是上传给云机器人的问题

		String INFO = URLEncoder.encode(question, "utf-8");
		String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY + "&info=" + INFO;
		URL getUrl = new URL(getURL);
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		connection.connect();

		// 取得输入流，并使用Reader读取
		BufferedReader reader = new BufferedReader(new InputStreamReader( connection.getInputStream(), "utf-8"));
		StringBuffer sb = new StringBuffer();
		String line = "";
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		reader.close();
		// 断开连接
		connection.disconnect();

		TuVo tuVo = JSON.parseObject(sb.toString(), TuVo.class);
		vo = new ResponseVo();
		vo.setContent(tuVo.getText());
		vo.setCreateTime(new Date().getTime());
		vo.setFromUserName(requestVo.getToUserName());
		vo.setToUserName(requestVo.getFromUserName());
		vo.setMsgType("text");
		message.setReplyContent(vo.getContent());

		messageService.save(message);
		return vo;
	}

	private int getType(RequestVo requestVo) {
		switch (requestVo.getMsgType()){
			case "text": return 1;
			case "image": return 2;
			case "voice": return 3;
			default: return -1;
		}
	}
}
