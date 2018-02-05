package cn.wolfcode.wechat.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/1/21.
 */
@Getter
@Setter
public class VerifyCodeVo implements Serializable{
    private String phoneNumber;
    private String VerifyCode;
    private Date sendTime;
}
