package com.my.springbootorigin.common.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public class PageQuery {

    protected long pageNum;
    protected long pageSize;
    protected Page page = new Page(0, 0);

    public long getPageNum() {
        return pageNum;
    }

    public void setPageNum(long pageNum) {
        this.pageNum = pageNum;
        this.page.setCurrent(pageNum);
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
        this.page.setSize(pageSize);
    }

    public Page getPage() {
        return page;
    }

}
