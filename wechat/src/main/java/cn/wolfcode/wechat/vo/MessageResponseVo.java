package cn.wolfcode.wechat.vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Setter;
import lombok.ToString;

/**
 * 
参数	描述
ToUserName	是	接收方帐号（收到的OpenID）
FromUserName	是	开发者微信号
CreateTime	是	消息创建时间 （整型）
MsgType	是	text
Content	是	回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
 *
 */

@Setter
@ToString
@XmlRootElement(name = "xml")
public class MessageResponseVo {
	
	private String toUserName;
	private String fromUserName;
	private Long createTime;
	private String msgType;
	private String content;
	
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
	
}
