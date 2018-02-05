package cn.wolfcode.wechat.service;

import cn.wolfcode.wechat.domain.Voice;

import java.util.List;

/**
 * Created by Administrator on 2018/2/3.
 */
public interface IVoiceService {
    int deleteByPrimaryKey(Long id);

    int insert(Voice record);

    Voice selectByPrimaryKey(Long id);

    List<Voice> selectAll();

    int updateByPrimaryKey(Voice record);

    List<Voice> selectByUserName(String userName);
}
