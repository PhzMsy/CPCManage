package org.msy.boot.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 11612
 * @date 2023/3/6
 */
@Data
public class BaseEntity {
    // 标注字段自动填充的执行时机，INSERT代表是在新增数据的时候为其填充默认值。
    @TableField(fill = FieldFill.INSERT)
// 逻辑删除字段 0：未删除，1：已删除
    @TableLogic
    private Integer is_deleted;
    private Date delete_time;

    public void setDeleteTime(Date date) {
        this.delete_time = date;
    }
}
