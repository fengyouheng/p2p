package cn.wolfcode.wechat.service;

import cn.wolfcode.wechat.domain.Menu;

import java.util.List;

/**
 * Created by cgs on 2018/2/2.
 */
public interface IMenuService {
    int save(Menu menu);
    List<Menu> selectByParentId(Long id);

    List<Menu> getMenuByParentId(Long parentId);
}
