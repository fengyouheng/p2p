package cn.wolfcode.wechat.service.impl;

import cn.wolfcode.wechat.domain.Client;
import cn.wolfcode.wechat.mapper.ClientMapper;
import cn.wolfcode.wechat.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.wolfcode.wechat.query.Pagination;

import java.util.List;

/**
 * Created by cgs on 2018/2/3.
 */
@Service
public class ClientServiceImpl implements IClientService {
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public int save(Client client) {
        return clientMapper.insert(client);
    }

    @Override
    public int update(Client client) {
        return clientMapper.updateByPrimaryKey(client);
    }

    @Override
    public Pagination queryAll() {
        //查询总数
      int count = clientMapper.queryCount();
        //查询数据
       List<Client> list = clientMapper.queryList();
        return new Pagination(count,list);
    }
}
