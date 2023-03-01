package org.msy.boot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;

/**
 * @author 11612
 * @date 2023/3/1
 */
@Data
@TableName("iof")
public class Iof {
    private Integer iofId;
    private Date iofInflow;
    private Date iofOutflow;
    private String iofOutaddress;
    private String iofJoinparty;
    private String iofManage;
    private String iofHelp;

}
