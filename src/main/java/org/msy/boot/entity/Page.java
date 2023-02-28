package org.msy.boot.entity;

import lombok.Data;

import java.util.List;

/**
 * @author 11612
 * @date 2023/2/27
 */
@Data
public class Page<T> {
    /* 查询某张表的 分页信息 */
    // 总页数
    private Integer pages;
    // 总记录数
    private Integer count;

    // 当前页
    //limit currentPage} - 1 * pageSize , pageSize
    private Integer currentPage;

    // 每页的记录数
    private Integer pageSize = 10;

    // 数据
    private List<T> data;

    // 查询条件  Menu User
    private T t;

    // 开始页 供mybatis进行数据库查询使用
    private Integer start;

    // 设置当前页面的方法： controller -> 查询列表数据方法
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
        this.start = (this.currentPage - 1) * pageSize;
//        this.pages = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
    }

    // 为页面中获取总页面数 进行计算
    public Integer getPages() {
        return count % 10 == 0 ?  count / pageSize : count / pageSize + 1;
    }
}
