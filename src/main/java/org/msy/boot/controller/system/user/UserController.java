package org.msy.boot.controller.system.user;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.msy.boot.entity.User;
import org.msy.boot.service.system.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.DateUtils;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    @GetMapping("/list.html/{p}")
    public ModelAndView list(@PathVariable("p") Integer currentPage,User user,ModelAndView modelAndView) {
        Page<User> userPage = new Page<>();
        userPage.setCurrent(currentPage);
        System.out.println(user);
        userPage.setSize(10);
        Page<User> UP = userServiceImpl.findUserList(user,userPage);
        System.out.println("打印UP"+UP);
        long count = 0;
        if(userPage.getTotal() % userPage.getSize() == 0) {
            if(userPage.getTotal() == 0) {
                count = 1;
            } else {
                count = userPage.getTotal() / userPage.getSize();
            }
        } else {
            count = userPage.getTotal() / userPage.getSize() + 1;
        }
        modelAndView.addObject("page",UP);
        modelAndView.addObject("count",count);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("user/userList");
        return modelAndView;
    }
    /**
     * 跳转到新增页面
     */
    @RequestMapping("/goAddOrUpd.html")
    public String goAddOrUpd(@RequestParam(value = "id",required = false) Integer
                                     id, Model model) {
        if(id != null) {
// 根据id检索数据库，把数据展示到更新页面
            User user = userServiceImpl.getById(id);
            model.addAttribute("user",user);
        }
        return "user/addOrUpdate";
    }
    @RequestMapping("/addOrUpdateUser")
    public String add(User user) {
        int i = userServiceImpl.addOrUpdateUser(user);
        if(i > 0) {
            return "redirect:/user/list.html/1";
        } else {
            return "";
        }
    }
    @RequestMapping("/deleteUser")
    public String delUser(Integer uid) {
        int count = userServiceImpl.delUser(uid);
        return "redirect:/user/list.html/1";
    }

}
