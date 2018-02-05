package cn.wolfcode.wechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 57611 on 2018/2/3.
 */
@Controller
public class MapController
{
    @RequestMapping("gzmap")
    public String map()
    {
        return "map";
    }
}
