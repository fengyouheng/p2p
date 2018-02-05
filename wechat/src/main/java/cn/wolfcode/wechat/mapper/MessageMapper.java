package cn.wolfcode.wechat.mapper;

import cn.wolfcode.wechat.domain.Message;
import cn.wolfcode.wechat.vo.RequestVo;

import java.util.List;

public interface MessageMapper {

    int insert(Message record);

}