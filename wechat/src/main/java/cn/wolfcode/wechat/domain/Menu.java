package cn.wolfcode.wechat.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by cgs on 2018/2/2.
 */
@Getter@Setter
@ToString
public class Menu {
    private Long id;
    private String name;
    private String url;
    private boolean view;
    private int order;
    private Long parentId;
}
