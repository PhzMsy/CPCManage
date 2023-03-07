package org.msy.boot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 11612
 * @date 2023/3/8
 */
@Data
@TableName("sys_power")
public class Power {
    private Integer pid;
    private Integer menu_power;
}
