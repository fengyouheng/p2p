package cn.wolfcode.wechat.vo;

import lombok.Setter;
import lombok.ToString;

import javax.swing.text.StringContent;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by 57611 on 2018/2/1.
 */
@Setter
@XmlRootElement(name = "xml")
@ToString
public class RequestVo
{
    String toUserName;
    String fromUserName;
    Long createTime;
    String msgType;
    String content;
    Long msgId;
    private String event;


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
    @XmlElement(name = "MsgId")
    public Long getMsgId()
    {
        return msgId;
    }
    @XmlElement(name = "Event")
    public String getevent() {
        return event;
    }
}
