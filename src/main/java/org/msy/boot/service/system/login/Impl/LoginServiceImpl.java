package org.msy.boot.service.system.login.Impl;

import org.msy.boot.entity.User;
import org.msy.boot.mapper.LoginMapper;
import org.msy.boot.service.system.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 11612
 * @date 2023/2/27
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;
    @Override
    public User checkLogin(User login) {
        return loginMapper.checkLogin(login);
    }
}
