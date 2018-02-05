package cn.wolfcode.wechat.vo;

import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by 57611 on 2018/2/1.
 */
@Setter
@XmlRootElement(name = "xml")
@ToString
public class ResponseVo
{
    String toUserName;
    String fromUserName;
    Long createTime;
    String msgType;
    String content;


    @XmlElement(name = "ToUserName")
    public String getToUserName()
    {
        return toUserName;
    }
    @XmlElement(name = "FromUserName")
    public String getFromUserName()
    {
        return fromUserName;
    }

    @XmlElement(name = "CreateTime")
    public Long getCreateTime()
    {
        return createTime;
    }
    @XmlElement(name = "MsgType")
    public String getMsgType()
    {
        return msgType;
    }
    @XmlElement(name = "Content")
    public String getContent()
    {
        return content;
    }

}
