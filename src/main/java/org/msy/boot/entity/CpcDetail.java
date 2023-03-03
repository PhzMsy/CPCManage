package org.msy.boot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;

/**
 * @author 11612
 * @date 2023/2/28
 * 详情信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("cpc_detail")
public class CpcDetail {
    @TableId(value = "cpc_id",type = IdType.AUTO)
    private Integer cpcId;

    private String cpcCname;
    private Date cpcBirth;
/*
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
*/
    private Date cpcJoin;
    private String cpcMarry;
    private String cpcAddress;
    private String cpcEmail;
    private String cpcNowaddr;
    private Date cpcJobtime;
    private String cpcStrengt;
    private String cpcDwadvise;
    private String cpcHomeadvise;
    private String cpcJnadvise;
    private String cpcOtheradvise;
    private String cpcRequire;
    @TableField(exist = false)
    private Cpc cpc;
    @TableField(exist = false)
    private Company cpcComid;
    @TableField(exist = false)
    private Party cpcParid;
    @TableField(exist = false)
    private List<Family> familyList;
    @TableField(exist = false)
    private Edu edu;
    @TableField(exist = false)
    private Iof iof;

}
