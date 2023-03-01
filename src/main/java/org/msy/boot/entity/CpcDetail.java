package org.msy.boot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
    private Cpc cpc;
    private Company cpcComid;
    private Party cpcParid;
    private List<Family> familyList;
    private Edu edu;
    private Iof iof;

}
