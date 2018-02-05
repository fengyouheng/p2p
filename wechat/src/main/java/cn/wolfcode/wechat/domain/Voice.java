package cn.wolfcode.wechat.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Voice {
    private Long id;

    private String personName;

    private String localId;

    private String userName;

}