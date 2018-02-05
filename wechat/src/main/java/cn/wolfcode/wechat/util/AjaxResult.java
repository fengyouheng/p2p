package cn.wolfcode.wechat.util;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by cgs on 2018/2/2.
 */
@Getter@Setter
public class AjaxResult {
    private String msg;
    private boolean success = true;

    public AjaxResult(String msg){
        this.msg = msg;
    }
    public AjaxResult(boolean success,String msg){
        this.msg = msg;
        this.success = success;
    }
}
