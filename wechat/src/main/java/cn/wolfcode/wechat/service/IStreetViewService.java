package cn.wolfcode.wechat.service;

import cn.wolfcode.wechat.query.PageResult;
import cn.wolfcode.wechat.query.StreetViewQueryObject;

import java.math.BigDecimal;

public interface IStreetViewService {

    PageResult query(StreetViewQueryObject qo, BigDecimal jing, BigDecimal wei);
}
