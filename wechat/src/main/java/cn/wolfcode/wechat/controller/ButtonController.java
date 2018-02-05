package cn.wolfcode.wechat.controller;

import cn.wolfcode.wechat.domain.Menu;
import cn.wolfcode.wechat.service.IMenuService;
import cn.wolfcode.wechat.util.HttpUtil;
import cn.wolfcode.wechat.util.TokenUtil;
import cn.wolfcode.wechat.util.UrlUtil;
import cn.wolfcode.wechat.vo.ButtonVo;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 57611 on 2018/2/1.
 */
@Controller
class ButtonController {
        @Value("${wechat.appID}")
        private String appid;

        @Autowired
        private IMenuService menuService;

        @RequestMapping("menu")
        @ResponseBody
        public String menu() {
            List<ButtonVo> buttonVos = new ArrayList<>();
            //第一个一级按钮 parentId = 1
            ButtonVo buttonVo1 = new ButtonVo();
            buttonVo1.setType("click");
            buttonVo1.setName("游玩广州");
            buttonVo1.setKey("V1001_TODAY_PLAY");

            //获取到id为1的所有子菜单
           List<Menu> list1 = menuService.getMenuByParentId(1L);
            System.out.println(list1);
            List<ButtonVo> sub_button1 = new ArrayList<>();
            ButtonVo buttonVo11 = null;
            for (Menu menu : list1) {
                buttonVo11 = new ButtonVo();
                buttonVo11.setType("view");
                buttonVo11.setName(menu.getName());
                buttonVo11.setUrl(menu.getUrl());
                System.err.println(buttonVo11);
                sub_button1.add(buttonVo11);
            }

            buttonVo1.setSub_button(sub_button1);


            //第二个按钮 parentId = 2
            //获取到id为1的所有子菜单
            ButtonVo buttonVo2 = new ButtonVo();
            buttonVo2.setType("click");
            buttonVo2.setName("美食推荐");
            buttonVo2 .setKey("V1001_TODAY_FOOD");

            List<Menu> list2 = menuService.getMenuByParentId(2L);
            System.out.println(list2);
            List<ButtonVo> sub_button2 = new ArrayList<>();
            ButtonVo buttonVo21 = null;
            for (Menu menu : list2) {
                buttonVo21 = new ButtonVo();
                buttonVo21.setType("view");
                buttonVo21.setName(menu.getName());
                buttonVo21.setUrl(menu.getUrl());
                sub_button2.add(buttonVo21);
            }

            buttonVo2.setSub_button(sub_button2);



            //第三个按钮 parentId = 3
            ButtonVo buttonVo3 = new ButtonVo();
            buttonVo3.setType("click");
            buttonVo3.setName("我的丁丁");
            buttonVo3 .setKey("V1001_TODAY_CAR");

            List<Menu> list3 = menuService.getMenuByParentId(3L);
            System.out.println(list3);
            List<ButtonVo> sub_button3 = new ArrayList<>();
            ButtonVo buttonVo31 = null;
            for (Menu menu : list3) {
                buttonVo31 = new ButtonVo();
                buttonVo31.setType("view");
                buttonVo31.setName(menu.getName());
                buttonVo31.setUrl(menu.getUrl());
                sub_button3.add(buttonVo31);
            }

            buttonVo3.setSub_button(sub_button3);

            buttonVos.add(buttonVo1);
            buttonVos.add(buttonVo2);
            buttonVos.add(buttonVo3);


            HashMap<String, List<ButtonVo>> buttonMap = new HashMap<>();
            buttonMap.put("button", buttonVos);

            String buttonUrl = UrlUtil.MENU_CREATE_URL + "?access_token=" + TokenUtil.getAccessTokenVo().getAccess_token();
            System.err.println("=============================="+buttonUrl);
            String ret = HttpUtil.post(buttonUrl, JSON.toJSONString(buttonMap));
            return ret;
        }

}
