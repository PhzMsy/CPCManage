package org.msy.boot.service.system.user;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.msy.boot.entity.User;

/**
 * @author 11612
 * @date 2023/2/28
 */
public interface UserService extends IService<User> {

    Page<User> findUserList(User user, Page<User> userPage);
    int addOrUpdateUser(User user);

    int delUser(Integer uid);
}
