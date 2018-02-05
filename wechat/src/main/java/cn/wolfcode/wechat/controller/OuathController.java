package cn.wolfcode.wechat.controller;

import cn.wolfcode.wechat.domain.Client;
import cn.wolfcode.wechat.service.IClientService;
import cn.wolfcode.wechat.util.HttpUtil;
import cn.wolfcode.wechat.util.UrlUtil;
import cn.wolfcode.wechat.vo.OAuthAccessTokenVo;
import cn.wolfcode.wechat.vo.UserInfoVo;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by cgs on 2018/2/3.
 */

@Controller
public class OuathController {
    @Value("${wechat.appID}")
    private String appId;
    @Value("${wechat.appsecret}")
    private String secret;
    @Autowired
    private IClientService clientService;

    @RequestMapping("oauth")
    public String oauth(String code){
        //获取touken
        String accessTokenUrl = UrlUtil.OAUTH_TOKEN_URL + "?appid="+appId+"&secret="+secret+"&code="+code+"&grant_type=authorization_code";
        String accessToken = HttpUtil.get(accessTokenUrl);
        OAuthAccessTokenVo oAuthAccessTokenVo = JSON.parseObject(accessToken, OAuthAccessTokenVo.class);
        //获取用户信息
        String userInfoUrl = UrlUtil.USERINFO_URL + "?access_token="+oAuthAccessTokenVo.getAccess_token()+"&openid="+oAuthAccessTokenVo.getOpenid()+"&lang=zh_CN";
        String userinfo = HttpUtil.get(userInfoUrl);
        //保存这个用户的信息
        UserInfoVo us = JSON.parseObject(accessToken, UserInfoVo.class);
        Client client = new Client();
        client.setConcernTime(new Date());//关注时间
        client.setNickname(us.getNickname());//设置昵称
        client.setOpenId(us.getOpenid());
        client.setStatus(1);//设置状态 关注?取关？
        //调用保存的方法
        clientService.save(client);
        return "redirect:http://www.baidu-x.com/?q=%E6%9D%A5%E4%B8%80%E6%B3%A2%E7%BE%8E%E5%A5%B3%E5%9B%BE%E7%89%87";
    }
}
