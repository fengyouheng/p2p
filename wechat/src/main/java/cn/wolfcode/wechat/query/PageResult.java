package cn.wolfcode.wechat.query;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Setter @Getter
public class PageResult {
    private int currentPage;
    private int pageSize;

    private int totalCount;
    private List<?> data;

    private int endPage;
    private int prevPage;
    private int nextPage;

    public PageResult(int currentPage, int pageSize, int totalCount, List<?> data) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.data = data;

        endPage = totalCount % pageSize != 0 ?
                totalCount / pageSize + 1 : totalCount / pageSize;
        prevPage = currentPage - 1 > 1 ?
                currentPage - 1 : 1;
        nextPage = currentPage + 1 < endPage ?
                currentPage + 1 : endPage;
    }

    public PageResult(int pageSize) {
        this(1,pageSize,0, Collections.EMPTY_LIST);
    }
}
