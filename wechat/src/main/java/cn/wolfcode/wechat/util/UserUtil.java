package cn.wolfcode.wechat.util;

import cn.wolfcode.wechat.domain.VerifyCodeVo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/2/3.
 */

public class UserUtil {

    private static Map<String, Object> map = new HashMap<>();

    public static void setUser(String name) {
        map.put("user", name);
    }

    public static String getUser() {
        return (String) map.get("user");
    }

    public static void setVo(VerifyCodeVo verifyCodeVo) {
        map.put("vo", verifyCodeVo);
    }

    public static VerifyCodeVo getVo() {
        return (VerifyCodeVo) map.get("vo");
    }


}
