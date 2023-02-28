package org.msy.boot.controller.system.menu;

import org.msy.boot.entity.Menu;
import org.msy.boot.entity.Page;
import org.msy.boot.service.system.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 11612
 * @date 2023/2/27
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/list.html/{p}")
    public String goMenuList(@PathVariable("p") Integer currentPage , Menu menu, HttpSession session, Model model) {
        System.out.println("初始化当前页数据 ");
        Page<Menu> page = new Page<>();
        // 设置当前页 和 起始 数据
        page.setCurrentPage(currentPage);
        page.setT(menu);
        System.out.println(menu);
        // 检索分页信息
        Page resultPage  = menuService.getMenuList(page);
        // 查询条件回显
        model.addAttribute("menu",menu);
        model.addAttribute("page",resultPage);

        return "menu/menuList";
    }
    @RequestMapping("/menuUpdate.html")
    public String toUpdate(@RequestParam("mid") Integer mid , Model model) {
        System.out.println("更新 数据初始化");
        // 更新数据初始化
        // Unknown column 'menu_list' in 'field list'
        Menu menu = menuService.selectMenuByMid(mid);

        // 初始化父级菜单的下拉框
        List<Menu> parentMenuList = menuService.selectParentMenu();

        model.addAttribute("menu",menu);
        model.addAttribute("parent",parentMenuList);
        return "menu/menuUpdate";
    }

    /**
     * 更新操作
     */
    @RequestMapping("/update")
    public String update(Menu menu ,Model model) {
        Integer count = menuService.updateMenu(menu);
        // 更新数据初始化
        if(count > 0 ) {
            Menu menu1 = menuService.selectMenuByMid(menu.getMid());
            model.addAttribute("menu",menu1);
        }
        return "forward:/menu/menuUpdate.html";
    }

    /**
     * 逻辑删除菜单信息操作
     */
    @RequestMapping("/delete")
    public String deleteMenu(@RequestParam("mid") Integer mid) {
        // 调用service 进行逻辑删除
        menuService.deleteMenu(mid);
        return "redirect:/menu/list.html/1";
    }

    /**
     * 批量删除
     */
    @PostMapping(value = "/batchDelete")
    public void batchDelete(String check) {
        // check : 4,5
        menuService.deleteBatchMenu(check);
    }

}
