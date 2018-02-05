package cn.wolfcode.wechat.util;

import cn.wolfcode.wechat.vo.TokenVo;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

/**
 * Created by 57611 on 2018/2/1.
 */

public class TokenUtil
{

    private static TokenVo accessTokenVo ;
    private static Properties p = new Properties();
    static{
        InputStream inStream = TokenUtil.class.getClassLoader().getResourceAsStream("wechat.properties");
        try {
            p.load(inStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        refreshAccessToken();
    }

    private static void refreshAccessToken(){
        String appid = p.getProperty("wechat.appID");
        String appsecret = p.getProperty("wechat.appsecret");

        //获取access_token
        String accessTokenUrl = UrlUtil.ACCESS_TOKEN_URL+"?grant_type=client_credential&appid="+appid+"&secret="+appsecret;
        String accessTokenRet = HttpUtil.get(accessTokenUrl);
        accessTokenVo = JSON.parseObject(accessTokenRet, TokenVo.class);
        accessTokenVo.setCreateTime(new Date().getTime());
    }

    public static TokenVo getAccessTokenVo(){
        if (!accessTokenVo.isVail()) {
            refreshAccessToken();
        }
        return accessTokenVo;
    }

}
