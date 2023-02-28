package org.msy.boot.service.system.login;

import org.msy.boot.entity.User;

/**
 * @author 11612
 * @date 2023/2/27
 */
public interface LoginService {
    User checkLogin(User login);
}
