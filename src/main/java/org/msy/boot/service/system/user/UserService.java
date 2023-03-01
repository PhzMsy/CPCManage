package org.msy.boot.service.system.user;

import org.msy.boot.entity.User;

/**
 * @author 11612
 * @date 2023/2/28
 */
public interface UserService {
    User selectUserByUserName(String username);

    int addUser(User user);

    int updUser(User user);

    int delUser(Integer uid);
}
