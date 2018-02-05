package cn.wolfcode.wechat.mapper;

import cn.wolfcode.wechat.domain.Order;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    Order selectByPrimaryKey(Long id);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);

    Order selectBySn(String sn);

    List<Order> select();

}