package cn.wolfcode.wechat.controller;

import cn.wolfcode.wechat.domain.SystemMenu;
import cn.wolfcode.wechat.service.ISystemMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by cgs on 2018/2/2.
 */
@Controller
public class MainController {
    @Autowired
    private ISystemMenuService systemMenuService;

    @RequestMapping("systemMenu")
    public String mainPage(){

        return "index";
    }

    @RequestMapping("main")
    @ResponseBody
    public List<SystemMenu> getMenu(){
        List<SystemMenu> result = systemMenuService.selectAll();

        return result;
    }

}
