package org.msy.boot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("_user")
public class User extends BaseEntity{
    @TableId(value = "uid",type = IdType.AUTO)
    private Integer uid;
    private String username;
    private String password;
    private Integer usertype;
    private Integer rid;
    private Integer status;


}