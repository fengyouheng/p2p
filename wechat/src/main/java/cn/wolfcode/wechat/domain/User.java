package cn.wolfcode.wechat.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;

    private Long phone;
    private String sn;
}