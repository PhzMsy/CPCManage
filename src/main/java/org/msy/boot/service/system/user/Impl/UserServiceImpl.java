package org.msy.boot.service.system.user.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.msy.boot.entity.User;
import org.msy.boot.mapper.UserMapper;
import org.msy.boot.service.system.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 11612
 * @date 2023/2/28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public Page<User> findUserList(User user, Page<User> userPage) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if(user.getUsername() != null) {
            wrapper.like("username",user.getUsername());
        }
// 如果用户类别为null，检索所有类别的用户
        if(user.getUsertype() != null) {
            wrapper.eq("usertype",user.getUsertype());
        }
// 默认查询所有状态的用户
        if(user.getStatus() != null) {
            wrapper.eq("status",user.getStatus());
        }
        wrapper.ne("uid",1);
// 1. 查询所有用户
        Page<User> userPage1 = userMapper.selectPage(userPage, wrapper);

        return userPage1;
    }

    @Override
    public int addOrUpdateUser(User user) {
        int count = 0;
        if(user.getUid() == null) {
// 新增操作
            count = userMapper.insert(user);
        } else {
// 修改操作
            count = userMapper.updateById(user);
        }
        return count;
    }

    @Override
    public int delUser(Integer uid) {
        User user = userMapper.selectById(uid);
        user.setDeleteTime(new Date());
        int count = userMapper.updateById(user);
// 更新成功删除时间之后再进行逻辑删除
        if(count > 0) {
            count = userMapper.deleteById(uid);
        }
        return count;
    }
}
