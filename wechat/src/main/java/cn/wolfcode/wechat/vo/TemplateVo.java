package cn.wolfcode.wechat.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

/**
 * Created by 57611 on 2018/2/1.
 */
@Setter
@Getter
@ToString
public class TemplateVo
{
    private String touser;
    private String template_id;
    private String url;
    private Map<String,TemplateValueVo> data;

}
