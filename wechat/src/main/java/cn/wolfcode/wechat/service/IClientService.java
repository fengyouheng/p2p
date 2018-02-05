package cn.wolfcode.wechat.service;

import cn.wolfcode.wechat.domain.Client;
import cn.wolfcode.wechat.query.Pagination;
/**
 * Created by cgs on 2018/2/3.
 */
public interface IClientService {
    int save(Client client);
    int update(Client client);

    Pagination queryAll();

}
