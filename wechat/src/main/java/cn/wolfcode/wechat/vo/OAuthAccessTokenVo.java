package cn.wolfcode.wechat.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * { "access_token":"ACCESS_TOKEN",
"expires_in":7200,
"refresh_token":"REFRESH_TOKEN",
"openid":"OPENID",
"scope":"SCOPE" }
 * @author Administrator
 *
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OAuthAccessTokenVo {
	private String access_token;
	private Long expires_in;
	private String refresh_token;
	private String openid;
	private String scope;
}
