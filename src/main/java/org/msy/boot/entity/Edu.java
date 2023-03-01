package org.msy.boot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author 11612
 * @date 2023/2/28
 * 学校信息表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("edu")
public class Edu {
    @TableId(value = "edu_id",type = IdType.AUTO)
    private Integer eduId;
    private String eduEdu;
    private String eduDegree;
    private String eduMajor;
    private String eduSchool;
    private String eduStrat;
    private String eduEnd;
}
