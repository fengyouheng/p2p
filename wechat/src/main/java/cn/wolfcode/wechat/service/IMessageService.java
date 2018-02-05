package cn.wolfcode.wechat.service;

import cn.wolfcode.wechat.domain.Message;
import cn.wolfcode.wechat.vo.RequestVo;

public interface IMessageService {
    int save(Message message);

}
