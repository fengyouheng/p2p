package cn.wolfcode.wechat.controller;

import cn.wolfcode.wechat.query.StreetViewQueryObject;
import cn.wolfcode.wechat.service.IStreetViewService;
import cn.wolfcode.wechat.util.HttpUtil;
import cn.wolfcode.wechat.util.SecurityUtil;
import cn.wolfcode.wechat.util.TokenUtil;
import cn.wolfcode.wechat.util.UrlUtil;
import cn.wolfcode.wechat.vo.TicketVo;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class StreetViewController {
    @Autowired
    private IStreetViewService streetViewService;

    @RequestMapping("list")
    public String list(@ModelAttribute("qo") StreetViewQueryObject qo, Model model, BigDecimal jing, BigDecimal wei){
        model.addAttribute("list",streetViewService.query(qo,jing,wei));

        String time = new Date().getTime() + "";
        String ticketUrl = UrlUtil.TICKET_GETTICKET_URL + "?access_token=" + TokenUtil.getAccessTokenVo().getAccess_token()+"&type=jsapi";
        String ret = HttpUtil.get(ticketUrl);
        TicketVo ticketVo = JSON.parseObject(ret, TicketVo.class);
        TreeMap<String, String> treemap = new TreeMap<>();
        treemap.put("noncestr", "12345678");
        treemap.put("jsapi_ticket", ticketVo.getTicket());
        treemap.put("timestamp", time);
        treemap.put("url", UrlUtil.MYINDEX + "/list");


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
        System.out.println(appid);
        System.out.println(time);
        System.out.println(signature);


        return "list";
    }


    @RequestMapping("shop")
    @ResponseBody
    public List shop(@ModelAttribute("qo") StreetViewQueryObject qo, BigDecimal jing, BigDecimal wei){
       return streetViewService.query(qo,jing,wei).getData();
    }

    /*@RequestMapping
    @ResponseBody
    public String LatitudeAndLongitude(BigDecimal jing,BigDecimal wei){
        String url = streetViewService
        return url;
    }*/

    @Value("${wechat.appID}")
    private String appid;

    /*@RequestMapping("list")
    @ResponseBody
    public String list(@ModelAttribute("qo") StreetViewQueryObject qo,Model model){
        PageResult query = streetViewService.query(qo);
        System.out.println(query);
        model.addAttribute("list",query);
        return "list";
    }*/


    @RequestMapping("streetView")
    public String streetView(Model model){
        //调用接口获取jsapi_ticket
        String time = new Date().getTime() + "";
        //步骤1. 对所有待签名参数按照字段名的ASCII 码从小到大排序（字典序）后，使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串string1：
        /**
         *
         * noncestr=Wm3WZYTPz0wzccnW
         jsapi_ticket=sM4AOVdWfPE4DxkXGEs8VMCPGGVi4C3VM0P37wVUCFvkVAy_90u5h9nbSlYy3-Sl-HhTdfl2fzFy1AOcHKP7qg
         timestamp=1414587457
         url=http://mp.weixin.qq.com?params=value
         */
        //https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi
        String ticketUrl = UrlUtil.TICKET_GETTICKET_URL + "?access_token=" + TokenUtil.getAccessTokenVo().getAccess_token()+"&type=jsapi";
        String ret = HttpUtil.get(ticketUrl);
        TicketVo ticketVo = JSON.parseObject(ret, TicketVo.class);
        TreeMap<String, String> treemap = new TreeMap<>();
        treemap.put("noncestr", "12345678");
        treemap.put("jsapi_ticket", ticketVo.getTicket());
        treemap.put("timestamp", time);
        treemap.put("url", UrlUtil.MYINDEX + "/streetView");


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
        return "streetView";
    }
    /*@Value("${wechat.appID}")
    private String appid;
    @Value("${wechat.nonceStr}")
    private String nonceStr;
    @RequestMapping("/streetView")
    public String streetView(Map<String,Object> map){
        //调用接口获取jsapi_ticket
        String ticketUrl = UrlUtil.TICKET_GETTICKET_URL+"?access_token="+ AccessTokenUtil.getAccessTokenVo().getAccess_token()+"&type=jsapi";
        String ticketRet = HttpUtil.get(ticketUrl);


         appId: '', // 必填，公众号的唯一标识
         timestamp: , // 必填，生成签名的时间戳
         nonceStr: '', // 必填，生成签名的随机串
         signature: '',// 必填，签名，见附录1
         jsApiList: [] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
        map.put("appId",appid);
        map.put("timestamp",new Date().getTime());
        map.put("nonceStr",nonceStr);
        map.put("signature",signature);
        return "streetView";
    }*/
    /*@ResponseBody
    @RequestMapping(value = "getJsTicket")
    public Map<String, Object> getWeJsTicket(HttpServletRequest request, String url) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            // 获取微信signature

            WxJsapiSignature sin = wxMpService.createJsapiSignature(url);
            map.put("appId", configStorage.getAppId());
            map.put("timestamp", sin.getTimestamp());
            map.put("nonceStr", sin.getNonceStr());
            map.put("signature", sin.getSignature());
        } catch (Exception e) {
            this.logger.error(e.getMessage());
        }
        return map;
    }*/
}
