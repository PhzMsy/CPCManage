package org.msy.boot.entity;

import lombok.Data;

/**
 * @author 11612
 * @date 2023/3/6
 */
@Data
public class Gc {
    private String from_table; // 该条数据来自于哪张表
    private String primary_key; // 该条数据的主键是哪个字段
    private String title; // 提示
    private Integer uid; // 主键值
    private String delete_time; // 删除时间

}
