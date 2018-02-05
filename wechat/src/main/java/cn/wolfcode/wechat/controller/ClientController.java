package cn.wolfcode.wechat.controller;

import cn.wolfcode.wechat.query.Pagination;
import cn.wolfcode.wechat.service.IClientService;
import cn.wolfcode.wechat.vo.MessageRequestVo;
import cn.wolfcode.wechat.vo.MessageResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ClientController {
    @Autowired
    private IClientService clientService;

    @RequestMapping(value = "client",method = RequestMethod.POST)
    @ResponseBody
    public Object client(@RequestBody MessageRequestVo requestVo){
        if ("text".equals(requestVo.getMsgType())) {
            //文本消息
            return sendMsg(requestVo,"你好");
        }else if("image".equals(requestVo.getMsgType())){
            return sendMsg(requestVo,"图片消息");
        }else if("event".equals(requestVo.getMsgType())){
            if("subscribe".equals(requestVo.getevent())){
                return sendMsg(requestVo,"订阅成功");
            }else if ("unsubscribe".equals(requestVo.getMsgType())){
                return "unsubscribe";
            }
        }
        return "success";
    }


    private MessageResponseVo sendMsg(MessageRequestVo requestVo,String content) {
        MessageResponseVo responseVo = new MessageResponseVo();
        responseVo.setContent(content);
        responseVo.setCreateTime(new Date().getTime());
        responseVo.setFromUserName(requestVo.getToUserName());
        responseVo.setMsgType("text");
        responseVo.setToUserName(requestVo.getFromUserName());
        return responseVo;
    }


    @RequestMapping("clientList")
    @ResponseBody
    public Pagination clientList(){
        Pagination pagination =  clientService.queryAll();
        return pagination;
    }

    @RequestMapping("addStore")
    public String add(){

        return "client";
    }
}
