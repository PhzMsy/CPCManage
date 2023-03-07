package org.msy.boot.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 11612
 * @date 2023/3/8
 */
@Data
public class ExportMouldDto implements Serializable {
    @ExcelProperty("序号")
    private Integer id;
    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("身份证号")
    private String idCard;
    @ExcelProperty("性别")
    private String sex;
    @ExcelProperty("民族")
    private String nation;
    @ExcelProperty("联系电话")
    private String phone;
    @ExcelProperty("户籍所在地")
    private String origin;
    @ExcelProperty("隶属管理支部")
    private String parName;
    @ExcelProperty("工作状态")
    private String workType;
    @ExcelProperty("流入日期")
    private String iofInflow;
}
