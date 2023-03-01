package org.msy.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.msy.boot.entity.User;

/**
 * @author 11612
 * @date 2023/2/28
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
