package cn.wolfcode.wechat.service;


import cn.wolfcode.wechat.domain.SystemMenu;

import java.util.List;

public interface ISystemMenuService {
	/*int deleteByPrimaryKey(Long id);
    int insert(SystemMenu record);
    SystemMenu selectByPrimaryKey(Long id);*/
    List<SystemMenu> selectAll();
    /*int updateByPrimaryKey(SystemMenu record);
	Pagination queryPage(SystemMenuQueryObject qo);
	List<SystemMenu> queryTree();
	List<SystemMenu> queryForRole();
	List<Long> queryMenuIdsListForRole(Long roleId);
	List<SystemMenu> indexMenu();

    List<Long> queryMenuIds(Long id);*/
}
