package cn.wolfcode.wechat.controller;

import cn.wolfcode.wechat.domain.Menu;
import cn.wolfcode.wechat.service.IMenuService;
import cn.wolfcode.wechat.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cgs on 2018/2/2.
 */
@Controller
public class SystemManagerController {

    @Autowired
    private IMenuService menuService;

    @RequestMapping("systemManager")
    public String system(){
        return "systemManager";
    }

    @RequestMapping("menuSave")
    @ResponseBody
    public AjaxResult save(Menu menu){
        System.out.println(menu);
       AjaxResult ajaxResult;
        try {
            //执行保存操作
            menuService.save(menu);
            ajaxResult = new AjaxResult("恭喜你保存成功");
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult = new AjaxResult(false,"保存失败");
        }
        return ajaxResult;
    }
}
