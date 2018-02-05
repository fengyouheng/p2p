package cn.wolfcode.wechat.util;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AjaxResult1 {
    private boolean success;
    private String msg;

    public AjaxResult1(String msg) {
        this.msg = msg;
    }

    public AjaxResult1(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }
}
