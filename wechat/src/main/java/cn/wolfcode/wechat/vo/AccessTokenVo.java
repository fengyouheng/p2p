package cn.wolfcode.wechat.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

//{"access_token":"ACCESS_TOKEN","expires_in":7200}
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccessTokenVo {
	private String access_token;
	private Long expires_in;
	private Long createTime;
	
	public boolean isVail(){
		if (expires_in != null) {
			long nowTime = new Date().getTime();
			if (nowTime<createTime+expires_in*1000) {
				return true;
			}
		}
		return false;
	}
}
