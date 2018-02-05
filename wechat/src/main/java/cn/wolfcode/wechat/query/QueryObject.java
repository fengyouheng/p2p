package cn.wolfcode.wechat.query;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class QueryObject {
    private int currentPage = 1;
    private int pageSize = 3;

    public int getStart(){
        return (currentPage - 1) * pageSize;
    }
}