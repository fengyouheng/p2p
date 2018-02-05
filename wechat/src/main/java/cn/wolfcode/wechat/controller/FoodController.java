package cn.wolfcode.wechat.controller;

import cn.wolfcode.wechat.util.HttpUtil;
import cn.wolfcode.wechat.util.SecurityUtil;
import cn.wolfcode.wechat.util.TokenUtil;
import cn.wolfcode.wechat.util.UrlUtil;
import cn.wolfcode.wechat.vo.OAuthAccessTokenVo;
import cn.wolfcode.wechat.vo.PeopleVo;
import cn.wolfcode.wechat.vo.TicketVo;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by 57611 on 2018/2/3.
 */
@Controller
public class FoodController
{

    @Value("${wechat.appID}")
    private String appid;

    @Value("${wechat.appsecret}")
    private String appsecret;

   /* @RequestMapping("check_people")
    @ResponseBody
    public String check()
    {
        code = HttpUtil.get("https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appid + "&redirect_uri=http://iinz6k.natappfree.cc/food_tuijian&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirec");
        System.out.println(code);
        return null;

    }*/

    @RequestMapping("food_tuijian")
    public String tuijian(String code,Model model)
    {
        String ticketUrl = UrlUtil.TICKET_GETTICKET_URL + "?access_token=" + TokenUtil.getAccessTokenVo().getAccess_token()+"&type=jsapi";
        String ret = HttpUtil.get(ticketUrl);
        TicketVo ticketVo = JSON.parseObject(ret, TicketVo.class);
        TreeMap<String, String> treemap = new TreeMap<>();
        treemap.put("noncestr", "12345678");
        treemap.put("jsapi_ticket", ticketVo.getTicket());
        String time = new Date().getTime()+"";
        treemap.put("timestamp", time);
        treemap.put("url", UrlUtil.MYINDEX + "/food_tuijian");



        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : treemap.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");

        }
        sb.deleteCharAt(sb.length() - 1);
        String signature = SecurityUtil.SHA1(sb.toString());


        model.addAttribute("appId",appid);
        model.addAttribute("timestamp",time);
        model.addAttribute("nonceStr","12345678");
        model.addAttribute("signature",signature);




        String s = HttpUtil.get("https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appid + "&secret=" + appsecret + "&code=" + code + "&grant_type=authorization_code");
        OAuthAccessTokenVo oAuthAccessTokenVo = JSON.parseObject(s, OAuthAccessTokenVo.class);
        System.out.println(oAuthAccessTokenVo.getOpenid());
        String s1 = HttpUtil.get("https://api.weixin.qq.com/sns/userinfo?access_token=" +oAuthAccessTokenVo.getAccess_token()+ "&openid=" + oAuthAccessTokenVo.getOpenid() + "&lang=zh_CN");
        PeopleVo peopleVo = JSON.parseObject(s1, PeopleVo.class);
        model.addAttribute("nickname",peopleVo.getNickname());
        model.addAttribute("city",peopleVo.getCity());
        model.addAttribute("country",peopleVo.getCountry());
        model.addAttribute("headimgurl",peopleVo.getHeadimgurl());
        System.out.println(peopleVo.getHeadimgurl());
        return "food_tuijian";

    }
    @RequestMapping("what")
    public String what()
    {
        return "what";
    }



}
