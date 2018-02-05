package cn.wolfcode.wechat.service.impl;

import cn.wolfcode.wechat.domain.User;
import cn.wolfcode.wechat.mapper.UserMapper;
import cn.wolfcode.wechat.service.IUserService;
import cn.wolfcode.wechat.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/2/3.
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public User selectBidPhone(String sn) {
        return userMapper.selectBidPhone(sn);
    }

    @Override
    public void bindPhone(String phoneNumber) {
        userMapper.bindPhone(phoneNumber, UserUtil.getUser());
    }

    @Override
    public User selectBySn(String sn) {
        return userMapper.selectBySn(sn);
    }

}
