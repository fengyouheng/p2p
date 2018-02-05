package cn.wolfcode.wechat.service.impl;

import cn.wolfcode.wechat.domain.StreetView;
import cn.wolfcode.wechat.mapper.StreetViewMapper;
import cn.wolfcode.wechat.query.PageResult;
import cn.wolfcode.wechat.query.StreetViewQueryObject;
import cn.wolfcode.wechat.service.IStreetViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class StreetViewServiceImpl implements IStreetViewService {
    @Autowired
    private StreetViewMapper streetViewMapper;

    @Override
    public PageResult query(StreetViewQueryObject qo, BigDecimal jing, BigDecimal wei) {
        String J = jing + "";
        int i = J.indexOf(".");
        String jret = J.substring(0, i + 2);

        String W = wei + "";
        int o = W.indexOf(".");
        String wret = W.substring(0, o + 2);

        if(jret == "113.25" && wret == "23.10")
        {
            qo.setAName("海珠区");
        }
        else if(jret == "113.23" && wret == "23.13")
        {
            qo.setAName("荔湾区");
        }
        else if(jret == "113.27" && wret == "23.13")
        {
            qo.setAName("越秀区");
        }
        else if(jret == "113.35" && wret == "23.12")
        {
            qo.setAName("天河区");
        }
        else if(jret == "113.27" && wret == "23.17")
        {
            qo.setAName("白云区");
        }
        else if(jret == "113.35" && wret == "23.95")
        {
            qo.setAName("番禺区");
        }
        else if(jret == "113.22" && wret == "23.40")
        {
            qo.setAName("花都区");
        }
        else if(jret == "113.45" && wret == "23.10")
        {
            qo.setAName("黄埔区");
        }
        else if(jret == "113.58" && wret == "23.55")
        {
            qo.setAName("从化区");
        }
        else if(jret == "113.83" && wret == "23.30")
        {
            qo.setAName("从化区");
        }
        else{
            qo.setAName("天河区");
        }


        int totalCount = streetViewMapper.queryForCount(qo);
        if(totalCount == 0){
            return new PageResult(qo.getPageSize());
        }
        List<StreetView> data = streetViewMapper.queryForList(qo);
        return new PageResult(qo.getCurrentPage(),qo.getPageSize(),totalCount,data);
    }
}
