package org.msy.boot.controller.system.login;

import org.msy.boot.entity.Menu;
import org.msy.boot.service.system.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * @author 11612
 * @date 2023/2/27
 */
@Controller
public class IndexController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/index.html")
    public String index(Model model) {
        List<Menu> list  = menuService.getAllMenu(0);
        model.addAttribute("menus",list);
        return "index";
    }

}
