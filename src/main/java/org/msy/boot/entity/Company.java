package org.msy.boot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * @author 11612
 * @date 2023/2/28
 * 公司表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("company")
public class Company {
    @TableId(value = "com_id",type = IdType.AUTO)
    private Integer comId;
    private String comName;
    private Date comDate;
    private String comMoney;
    private String comAddress;
    private String comPro;
    private String comBbs;
    private String comHonour;

}
