package org.msy.boot.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * @author 11612
 * @date 2023/2/28
 * 基础信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("cpc")
@Validated //数据校验
public class Cpc {
    @TableId(value = "cpc_id",type = IdType.AUTO)
    private Integer cpcId;
    @NotNull
    private String cpcName;
    @ExcelProperty(value = "籍贯")
    private String cpcOrigin;
    @ExcelProperty(value = "性别")
    private String cpcSex;
    private String cpcNation;
    @ExcelProperty(value = "身份证号")
    @TableField("cpc_idcard")
    private String cpcIdCard;
    private String cpcPhone;
    @ExcelProperty(value = "当前工作状态")
    private String cpcWorktype;

}
