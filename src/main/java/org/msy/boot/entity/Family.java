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
 * 家庭信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("family")
public class Family {
    @TableId(value = "fa_id",type = IdType.AUTO)
    private Integer faId;
    private String faRelation;
    private String faName;
    private String faBirth;
    private String faJob;
    private String faPost;
    private String faPhone;
    private String faOther;
    private Integer faCpcid; // 与基础表链接
}
