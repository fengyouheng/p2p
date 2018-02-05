package cn.wolfcode.wechat.controller;

import cn.wolfcode.wechat.domain.Voice;
import cn.wolfcode.wechat.service.IVoiceService;
import cn.wolfcode.wechat.util.*;
import cn.wolfcode.wechat.vo.TicketVo;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Administrator on 2018/2/2.
 */
@Controller
public class VoiceController {
    @Autowired
    private IVoiceService voiceService;
    @Value("${wechat.nonceStr}")
    private String nonceStr;
    @Value("${wechat.appID}")
    private String appId;
    @Value("${wechat.indexUrl}")
    private String indexUrl;


    @RequestMapping("voice")
    public String voice(Map<String, Object> map) {
        //调用接口获取jsapi_ticket
        String ticket = UrlUtil.TICKET_GETTICKET_URL + "?access_token=" + TokenUtil.getAccessTokenVo().getAccess_token() + "&type=jsapi";
        String ticketRet = HttpUtil.get(ticket);
        TicketVo ticketVo = JSON.parseObject(ticketRet, TicketVo.class);

        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("noncestr", nonceStr);
        treeMap.put("jsapi_ticket", ticketVo.getTicket());
        String timestamp = new Date().getTime() + "";
        treeMap.put("timestamp", timestamp);
        treeMap.put("url", indexUrl + "/voice");

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        String signature = SecurityUtil.SHA1(sb.toString());

        map.put("appId", appId);
        map.put("timestamp", timestamp);
        map.put("nonceStr", nonceStr);
        map.put("signature", signature);
        map.put("url", indexUrl + "/voice");
        map.put("indexUrl", indexUrl);


        return "voice";
    }

    @RequestMapping("result")
    public String result(Voice voice, Model model) {
        model.addAttribute("list", voiceService.selectByUserName(UserUtil.getUser()));
        voice.setUserName(UserUtil.getUser());
        voiceService.insert(voice);
        model.addAttribute("person", voice.getPersonName());
        model.addAttribute("indexUrl", indexUrl);
        return "result";
    }
}
