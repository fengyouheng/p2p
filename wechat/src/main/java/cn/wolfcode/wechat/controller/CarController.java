package cn.wolfcode.wechat.controller;

import cn.wolfcode.wechat.domain.Order;
import cn.wolfcode.wechat.domain.User;
import cn.wolfcode.wechat.service.IOrderService;
import cn.wolfcode.wechat.service.IUserService;
import cn.wolfcode.wechat.service.IVerifyCodeVoService;
import cn.wolfcode.wechat.util.AjaxResult1;
import cn.wolfcode.wechat.util.UserUtil;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/2/3.
 */
@Controller
public class CarController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IVerifyCodeVoService verifyCodeVoService;
    @Autowired
    private IOrderService orderService;

    @RequestMapping("car")
    public String car() {
        return "car";
    }

    @RequestMapping("sendVerifyCode")
    @ResponseBody
    public AjaxResult1 sendVerifyCode(String phoneNumber) {
        try {
            verifyCodeVoService.sendVerifyCode(phoneNumber);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult1(e.getMessage());
        }
        return new AjaxResult1(true, "发送验证码成功");
    }

    @RequestMapping("callCar")
    @ResponseBody
    public AjaxResult1 callCar(Order order) {
        User user = userService.selectBidPhone(UserUtil.getUser());
        if (user == null) {
            return new AjaxResult1("第一次使用,请先绑定手机号");
        } else {
            Order order1 = orderService.selectBySn(UserUtil.getUser());
            if (order1 != null) {
                return new AjaxResult1("你有一个订单正在进行");
            }
            order.setUsername(UserUtil.getUser());
            order.setState(0L);
            order.setBeginDate(new Date());
            orderService.insert(order);
            return new AjaxResult1(true, "");
        }
    }

    @RequestMapping("/bindPhone")
    @ResponseBody
    public AjaxResult1 bindPhone(String phoneNumber, String verifyCode) {
        try {
            userService.bindPhone(phoneNumber);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult1(e.getMessage());
        }
        return new AjaxResult1(true, "绑定成功");
    }

    @RequestMapping("/checkState")
    @ResponseBody
    public AjaxResult1 checkState(String phoneNumber, String verifyCode) {
        User user = userService.selectBidPhone(UserUtil.getUser());
        Order order1 = orderService.selectBySn(UserUtil.getUser());
        if (user == null) {
            return new AjaxResult1("第一次使用,请先绑定手机号");
        } else if (order1 != null) {
            return new AjaxResult1(true, "你有一个订单正在进行");
        } else {
            return null;
        }
    }

    @RequestMapping("/order")
    public String order(Model model) {
        List<Order> orders = orderService.selectAll();
        model.addAttribute("orders", orders);
        return "order";
    }

    @RequestMapping("/info")
    public String info(Model model) {
        model.addAttribute("info", userService.selectBySn(UserUtil.getUser()));
        return "info";
    }

    @RequestMapping("/orders")
    public String orders(Model model) {
        model.addAttribute("orders", orderService.select());
        return "orders";
    }

    @RequestMapping("/getOrder")
    @ResponseBody
    public AjaxResult1 getOrder(Long id) {
        try {
            User user = userService.selectBySn(UserUtil.getUser());
            Order order = orderService.selectByPrimaryKey(id);
            order.setEndDate(new Date());
            order.setOrderUserId(user.getId());
            order.setState(1L);
            orderService.updateByPrimaryKey(order);

        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult1("");
        }
        return new AjaxResult1(true, "");
    }


    @RequestMapping("/reg")
    @ResponseBody
    public AjaxResult1 reg(Long phoneNumber) {
        try {
            User user = new User();
            user.setPhone(phoneNumber);
            user.setSn(UserUtil.getUser());
            userService.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult1("2222");
        }
        return new AjaxResult1(true, "注册绑定成功");
    }

    @RequestMapping("/success")
    public String success(){
        return "success";
    }

}
