package cn.wolfcode.wechat.mapper;


import cn.wolfcode.wechat.domain.SystemMenu;

import java.util.List;

public interface SystemMenuMapper {
    /*int deleteByPrimaryKey(Long id);
    int insert(SystemMenu record);
    SystemMenu selectByPrimaryKey(Long id);*/
    List<SystemMenu> selectAll();
    /*int updateByPrimaryKey(SystemMenu record);
    Long queryPageCount(SystemMenuQueryObject qo);
    List<SystemMenu> queryPageDataResult(SystemMenuQueryObject qo);
    List<SystemMenu> queryTree();
    List<Long> systemMenuMapper(Long roleId);
    List<Long> queryMenuIdListByEmployeeId(Long id);*/
}
