package com.example.test.commons;

public class ClientPage {
    //实际页数
    private Integer currentPage;
    //每页数
    private Integer pageSize;
    //当前
    private Integer pageNum;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public ClientPage() {
        this.pageNum = 1;
        this.pageSize = 5;
    }

    public Integer getCurrentPage() {

        return (this.pageNum-1)*this.pageSize;
    }

    public void setCurrentPage(Integer pageNum) {
        this.currentPage = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
