package org.msy.boot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 11612
 * @date 2023/2/28
 * 组织表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("party")
public class Party {
    @TableId(value = "par_id",type = IdType.AUTO)
    private Integer parId;
    private String parName;
    private String parPid;
}
