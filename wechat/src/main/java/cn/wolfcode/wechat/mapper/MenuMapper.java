package cn.wolfcode.wechat.mapper;

import cn.wolfcode.wechat.domain.Menu;

import java.util.List;

/**
 * Created by cgs on 2018/2/2.
 */

public interface MenuMapper {
    int insert(Menu menu);
    List<Menu> selectByParentId(Long parentId);
}
