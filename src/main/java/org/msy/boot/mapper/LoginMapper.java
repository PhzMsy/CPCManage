package org.msy.boot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.msy.boot.entity.User;
import org.springframework.stereotype.Service;


/**
 * @author 11612
 * @date 2023/2/27
 */
@Mapper
public interface LoginMapper {
    @Select("select * from _user where username = #{username} and password = #{password}")
    User checkLogin(User login);

}
