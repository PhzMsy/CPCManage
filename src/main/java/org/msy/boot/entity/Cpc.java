package org.msy.boot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 11612
 * @date 2023/2/28
 * 基础信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("cpc")
public class Cpc {
    @TableId(value = "cpc_id",type = IdType.AUTO)
    private Integer cpcId;
    private String cpcName;
    private String cpcOrigin;
    private String cpcSex;
    private String cpcNation;
    @TableField("cpc_idcard")
    private String cpcIdCard;
    private String cpcPhone;
    private String cpcWorktype;

}
