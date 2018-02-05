package cn.wolfcode.wechat.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Created by 57611 on 2018/2/1.
 */
@Setter
@Getter
@ToString
public class TokenVo
{
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
