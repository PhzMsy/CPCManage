package org.msy.boot.controller.system.login;


import org.msy.boot.entity.User;
import org.msy.boot.service.system.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    private LoginService loginServiceImpl;

    @PostMapping("/login")
    public String login(User login, HttpSession session) {
        User loginUser = loginServiceImpl.checkLogin(login);
        System.out.println(loginUser != null);
        if (loginUser != null) {
            // 将登录对象放入 Session 会话中 后续只需验证会话中是否有这个对象就可以知道是否登录
            session.setAttribute("loginUser", loginUser);
            return "redirect:/index.html";
        } else {
            session.setAttribute("msg","用户名/密码错误！");
            return "/login.html";
        }
    }

    @GetMapping({"/", "/login.html"})
    public String logout() {
        System.out.println("到这来了");
        return "login";
    }
}
