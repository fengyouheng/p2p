package cn.wolfcode.wechat.controller;

import cn.wolfcode.wechat.util.HttpUtil;
import cn.wolfcode.wechat.vo.OAuthAccessTokenVo;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 57611 on 2018/2/1.
 */
@Controller
public class CheckController
{
    @Value("${wechat.appID}")
    private String appid;
    @Value("${wechat.appsecret}")
    private String appsecret;
    @RequestMapping("check")
    @ResponseBody
    public String check(String code)
    {

        //有些地方是写死的
        String s = HttpUtil.get("https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appid + "&secret=" + appsecret + "&code=" + code + "&grant_type=authorization_code");
        OAuthAccessTokenVo oAuthAccessTokenVo = JSON.parseObject(s, OAuthAccessTokenVo.class);
        System.out.println(oAuthAccessTokenVo.getAccess_token());
        String s1 = HttpUtil.get("https://api.weixin.qq.com/sns/userinfo?access_token=" +oAuthAccessTokenVo.getAccess_token()+ "&openid=" + "okhRQ0T1GWImOPKdHX74UlDihRs8" + "&lang=zh_CN");
        System.out.println(s1);
        return "success";
    }
}
