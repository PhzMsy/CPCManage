package org.msy.boot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

/**
 * @author 11612
 * @date 2023/2/27
 */
@Data
@TableName("menu")
public class Menu extends BaseEntity{

    // ASSIGN_ID -> 19位的主键
//    @TableId(type = IdType.ASSIGN_ID)
    private Integer mid ;

    // 标注当前属性名对应的字段名称
    @TableField("m_name")
    private String mName;
    private Integer pid;
    private Integer status;
    private String href ;

    @TableField("p_name")
    private String pName;

    private List<Menu> menuList;

}