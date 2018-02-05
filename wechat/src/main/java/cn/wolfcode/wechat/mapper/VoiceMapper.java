package cn.wolfcode.wechat.mapper;

import cn.wolfcode.wechat.domain.Voice;

import java.util.List;

public interface VoiceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Voice record);

    Voice selectByPrimaryKey(Long id);

    List<Voice> selectAll();

    int updateByPrimaryKey(Voice record);

    List<Voice> selectByUserName(String userName);
}