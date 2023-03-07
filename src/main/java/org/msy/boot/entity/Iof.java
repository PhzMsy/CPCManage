package org.msy.boot.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

/**
 * @author 11612
 * @date 2023/3/1
 */
@Data
@TableName("iof")
public class Iof {
    @TableId(value = "iof_id", type = IdType.AUTO)
    private Integer iofId;
    //    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ExcelProperty(value = "流入日期")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private String iofInflow;
    //    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private String iofOutflow;
    private String iofOutaddress;
    private String iofJoinparty;
    private String iofManage;
    private String iofHelp;

}
