package org.msy.boot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("_user")
public class User {
    private Integer uid;
    private String username;
    private String password;
    private String usertype;
    private String ename;

}
