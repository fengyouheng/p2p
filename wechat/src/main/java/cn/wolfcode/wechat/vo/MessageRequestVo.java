package cn.wolfcode.wechat.vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Setter;
import lombok.ToString;

/**
 * 
参数	描述
ToUserName	开发者微信号
FromUserName	发送方帐号（一个OpenID）
CreateTime	消息创建时间 （整型）
MsgType	text
Content	文本消息内容
MsgId	消息id，64位整型
 * @author Administrator
 *
 */

@Setter
@ToString
@XmlRootElement(name = "xml")
public class MessageRequestVo {
	
	private String toUserName;
	private String fromUserName;
	private Long createTime;
	private String msgType;
	private String content;
	private Long msgId;
	private String event;
	
	@XmlElement(name = "ToUserName")
	public String getToUserName() {
		return toUserName;
	}
	@XmlElement(name = "FromUserName")
	public String getFromUserName() {
		return fromUserName;
	}
	@XmlElement(name = "CreateTime")
	public Long getCreateTime() {
		return createTime;
	}
	@XmlElement(name = "MsgType")
	public String getMsgType() {
		return msgType;
	}
	@XmlElement(name = "Content")
	public String getContent() {
		return content;
	}
	@XmlElement(name = "MsgId")
	public Long getMsgId() {
		return msgId;
	}
	@XmlElement(name = "Event")
	public String getevent() {
		return event;
	}

	
}
