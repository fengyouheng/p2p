package cn.wolfcode.wechat.service;

import cn.wolfcode.wechat.domain.Order;

import java.util.List;

/**
 * Created by Administrator on 2018/2/3.
 */
public interface IOrderService {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    Order selectByPrimaryKey(Long id);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);

    Order selectBySn(String user);

    List<Order>  select();

}
