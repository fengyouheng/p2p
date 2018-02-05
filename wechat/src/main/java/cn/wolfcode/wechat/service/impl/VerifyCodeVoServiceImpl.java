package cn.wolfcode.wechat.service.impl;

import cn.wolfcode.wechat.domain.VerifyCodeVo;
import cn.wolfcode.wechat.service.IVerifyCodeVoService;
import cn.wolfcode.wechat.util.DateUtil;
import cn.wolfcode.wechat.util.UserUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2018/1/21.
 */
@Service
@Transactional
public class VerifyCodeVoServiceImpl implements IVerifyCodeVoService {

    @Override
    public void sendVerifyCode(String phoneNumber) {
        VerifyCodeVo verifyCodeVo = UserUtil.getVo();
        if (verifyCodeVo == null ||
                DateUtil.getBetweenTime(verifyCodeVo.getSendTime(), new Date()) > 5) {

            //生成验证码
            String uuid = UUID.randomUUID().toString().substring(0, 4);
            //拼接要发送的短信内容
            StringBuilder msg = new StringBuilder();
            msg.append("您的验证码为").append(uuid).append(",验证码有效期为").append("5分钟");
            try {
                sendMessage(phoneNumber, msg.toString());
                verifyCodeVo = new VerifyCodeVo();
                verifyCodeVo.setPhoneNumber(phoneNumber);
                verifyCodeVo.setSendTime(new Date());
                verifyCodeVo.setVerifyCode(uuid);
                UserUtil.setVo(verifyCodeVo);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } else {
            throw new RuntimeException("操作过于频繁，请稍后再试");
        }
    }

    private void sendMessage(String phoneNumber, String content) throws Exception {

    }
}