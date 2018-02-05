package cn.wolfcode.wechat.mapper;

import cn.wolfcode.wechat.domain.Client;

import java.util.List;

/**
 * Created by cgs on 2018/2/3.
 */
public interface ClientMapper {
    int insert(Client client);
    int updateByPrimaryKey(Client client);

    int queryCount();

    List<Client> queryList();
}
