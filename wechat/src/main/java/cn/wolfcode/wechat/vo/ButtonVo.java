package cn.wolfcode.wechat.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

/**
 * Created by 57611 on 2018/2/1.
 */
@Setter
@Getter
@ToString
public class ButtonVo {

    private String type;
    private String name;
    private String key;
    private String url;
    private List<ButtonVo> sub_button = new ArrayList<>();

}
