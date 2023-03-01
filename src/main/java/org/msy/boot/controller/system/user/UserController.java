package org.msy.boot.controller.system.user;


import org.msy.boot.entity.User;
import org.msy.boot.service.system.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    @RequestMapping("/list.html")
    public String goList() {
        return "user/userList";
    }


    @PostMapping("/register")
    public String addUser(User user , String password1, String password2, HttpSession session) {
        // "" == ""  null == null ???
        if(!"".equals(password1) && !"".equals(password2) && password1 != null && password2 != null) {
            if(password1.equals(password2)) {
                // 两次输入密码一致
                user.setPassword(password1);

                // 验证当前输入的用户名是否已经存在
                User cUser = userServiceImpl.selectUserByUserName(user.getUsername());
                if( cUser == null ) {
                    // 可以注册
                    int count = userServiceImpl.addUser(user);
                    if(count > 0) {
                        // 注册成功
                        // 跳转到登录页面，并提示 注册成功
                        session.setAttribute("msg","注册成功！");
                        return "redirect:/login.html";
                    } else {
                        // 注册失败
                        session.setAttribute("reg_msg","注册失败！");
                        return "redirect:/register.html";
                    }
                } else {
                    // 不能注册， 提示 “该用户名已存在”
                    session.setAttribute("reg_msg","该用户名已存在！");
                    return "redirect:/register.html";
                }
            } else {
                // 两次输入密码不一致
                // 返回到注册页面， 并提示“两次输入的密码不一致”
                session.setAttribute("reg_msg","两次输入的密码不一致！");
                return "redirect:/register.html";
            }
        } else {
            // 输入空的密码， 提示“密码不能为空”
            session.setAttribute("reg_msg","密码不能为空！");
            return "redirect:/register.html";

        }



    }

}
