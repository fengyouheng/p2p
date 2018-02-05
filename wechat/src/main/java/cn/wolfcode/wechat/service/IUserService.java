package cn.wolfcode.wechat.service;

import cn.wolfcode.wechat.domain.User;

import java.util.List;

/**
 * Created by Administrator on 2018/2/3.
 */
public interface IUserService {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User selectBidPhone(String user);

    void bindPhone(String phoneNumber);

    User selectBySn(String user);
}
