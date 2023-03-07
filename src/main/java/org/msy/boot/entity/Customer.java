package org.msy.boot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 11612
 * @date 2023/3/7
 */
@Data
@TableName("customer")
public class Customer {
    private Integer id;
    private String name;
    private String test;
    private Integer parid;
    private String idcard;
    private String phone;
    private String status;
    private String creatName;
    private String creatTime;
    private String other;
}
