package cn.wolfcode.wechat.service.impl;

import cn.wolfcode.wechat.domain.Message;
import cn.wolfcode.wechat.mapper.MessageMapper;
import cn.wolfcode.wechat.service.IMessageService;
import cn.wolfcode.wechat.vo.RequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements IMessageService{
    @Autowired
    private MessageMapper messageMapper;

    public int save(Message message) {
        return messageMapper.insert(message);
    }

}
