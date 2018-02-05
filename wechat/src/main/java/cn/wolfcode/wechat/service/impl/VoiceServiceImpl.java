package cn.wolfcode.wechat.service.impl;

import cn.wolfcode.wechat.domain.Voice;
import cn.wolfcode.wechat.mapper.VoiceMapper;
import cn.wolfcode.wechat.service.IVoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/2/3.
 */
@Service
@Transactional
public class VoiceServiceImpl implements IVoiceService {
    @Autowired
    private VoiceMapper voiceMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return voiceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Voice record) {
        return voiceMapper.insert(record);
    }

    @Override
    public Voice selectByPrimaryKey(Long id) {
        return voiceMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Voice> selectAll() {
        return voiceMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Voice record) {
        return voiceMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Voice> selectByUserName(String userName) {
        return voiceMapper.selectByUserName(userName);
    }
}
