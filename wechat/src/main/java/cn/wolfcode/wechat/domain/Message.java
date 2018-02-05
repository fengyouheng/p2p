package cn.wolfcode.wechat.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class Message {
    private Long id;

    private Long clientId;  //指哪个用户发来的

    private String receiveContent;//用户发送的内容

    private String replyContent;//回复给用户的内容

    private int type;//文本，图片，语言等

    private Date inputTime;//当前系统时间

}