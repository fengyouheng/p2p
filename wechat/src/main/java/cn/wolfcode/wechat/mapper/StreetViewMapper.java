package cn.wolfcode.wechat.mapper;

import cn.wolfcode.wechat.domain.StreetView;
import cn.wolfcode.wechat.query.StreetViewQueryObject;

import java.util.List;

public interface StreetViewMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StreetView record);

    StreetView selectByPrimaryKey(Long id);

    List<StreetView> selectAll();

    int updateByPrimaryKey(StreetView record);

    int queryForCount(StreetViewQueryObject qo);

    List<StreetView> queryForList(StreetViewQueryObject qo);
}