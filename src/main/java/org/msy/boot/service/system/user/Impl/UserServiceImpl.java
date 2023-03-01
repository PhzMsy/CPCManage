package org.msy.boot.service.system.user.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.msy.boot.entity.User;
import org.msy.boot.mapper.UserMapper;
import org.msy.boot.service.system.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 11612
 * @date 2023/2/28
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserByUserName(String username) {
        // 查询条件构造器
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("username",username);
        return userMapper.selectOne(wrapper);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int updUser(User user) {
        UpdateWrapper<User> wrapper = new UpdateWrapper();
        wrapper.eq("uid",user.getUid());
        return userMapper.update(user,wrapper);
    }

    @Override
    public int delUser(Integer uid) {
        return 0;
    }
}
