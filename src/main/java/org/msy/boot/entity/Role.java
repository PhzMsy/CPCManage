package org.msy.boot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 11612
 * @date 2023/3/8
 */
@Data
@TableName("sys_role")
public class Role extends BaseEntity{
    private Integer rid;
    private String rname;
    private Integer status;
    @TableField(exist = false)
    private Power power;
}
