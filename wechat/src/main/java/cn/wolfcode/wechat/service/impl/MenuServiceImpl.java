package cn.wolfcode.wechat.service.impl;

import cn.wolfcode.wechat.domain.Menu;
import cn.wolfcode.wechat.mapper.MenuMapper;
import cn.wolfcode.wechat.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cgs on 2018/2/2.
 */
@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public int save(Menu menu) {
        return menuMapper.insert(menu);
    }

    @Override
    public List<Menu> selectByParentId(Long id) {
        return menuMapper.selectByParentId(id);
    }

    @Override
    public List<Menu> getMenuByParentId(Long parentId) {
        return menuMapper.selectByParentId(parentId);
    }
}
