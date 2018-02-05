package cn.wolfcode.wechat.controller;

import cn.wolfcode.wechat.util.HttpUtil;
import cn.wolfcode.wechat.util.TokenUtil;
import cn.wolfcode.wechat.vo.TemplateValueVo;
import cn.wolfcode.wechat.vo.TemplateVo;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 57611 on 2018/2/1.
 */
@Controller
public class TemplateController
{

    private String token;
    @RequestMapping("template")
    @ResponseBody
    public String template()
    {
        TemplateVo vo = new TemplateVo();
        vo.setTouser("okhRQ0T1GWImOPKdHX74UlDihRs8");
        vo.setTemplate_id("iQ-m3l9sVYCDIfk4gtgWA2M9p1tNg2haURsGFcZtDtA");
        vo.setUrl("http://www.taobao.com");
        Map data = new HashMap<>();
        data.put("first",new TemplateValueVo("恭喜你購買成功","#173177"));
        data.put("keynote1",new TemplateValueVo("巧克力","#173177"));
        data.put("keynote2",new TemplateValueVo("40元","#173177"));
        //data.put("keynote3",new TemplateValueVo(new Date().toLocaleString(),"#173177"));
        data.put("remark",new TemplateValueVo("歡迎再次購買","#173177"));
        vo.setData(data);
        String s = JSON.toJSONString(vo);
        System.out.println(TokenUtil.getAccessTokenVo ().getAccess_token());
        String post = HttpUtil.post("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + TokenUtil.getAccessTokenVo ().getAccess_token(), s);
        return  post;
    }
}
