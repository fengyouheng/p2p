package cn.wolfcode.wechat.mapper;

import cn.wolfcode.wechat.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User selectBidPhone(String sn);

    void bindPhone(@Param("phone") String phoneNumber, @Param("sn") String user);

    User selectBySn(String sn);
}