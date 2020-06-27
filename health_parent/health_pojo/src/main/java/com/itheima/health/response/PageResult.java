package com.itheima.health.response;

import java.io.Serializable;
import java.util.List;


public class PageResult<T> implements Serializable {
    private Long total;//总记录数
    private List<T> rows;//分页结果
    private Integer totalPages;//总页数

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}
