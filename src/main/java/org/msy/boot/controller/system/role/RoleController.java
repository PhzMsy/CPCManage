package org.msy.boot.controller.system.role;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.msy.boot.entity.Menu;
import org.msy.boot.entity.Role;
import org.msy.boot.entity.RoleVo;
import org.msy.boot.service.system.menu.MenuService;
import org.msy.boot.service.system.role.RoleService;
import org.msy.boot.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * @author 11612
 * @date 2023/3/8
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleServiceImpl;
    @Autowired
    private MenuService menuServiceImpl;

    // 列表页
    @RequestMapping("/list.html/{current}")
    public String list(@PathVariable Integer current, Model model, RoleVo roleVo) {
        Page<Role> rolePage = roleServiceImpl.findRoleList(current, roleVo);
        long count = 0;
// 总记录数 与 每页记录数 相等
        if (rolePage.getTotal() % rolePage.getSize() == 0) {
            if (rolePage.getTotal() == 0) {
                count = 1;
            } else {
                count = rolePage.getTotal() / rolePage.getSize();
            }
        } else {
            count = rolePage.getTotal() / rolePage.getSize() + 1;
        }
        model.addAttribute("page", rolePage);
        model.addAttribute("count", count);
        model.addAttribute("roleVo", roleVo);
        return "role/roleList";
    }

    // 列表树
    @RequestMapping("/showMenu")
    @ResponseBody
    public String showMenu(Integer rid) {
// 检索全部 menu
        List<Menu> allMenu = menuServiceImpl.getAllMenu(0);
// 该角色具有哪些菜单的可见权限 power表中的menu_power字段
        List<Map<String, Object>> powerRole = roleServiceImpl.findPower(rid);
        if (powerRole != null && powerRole.size() > 0) {
            Object mp = powerRole.get(0).get("menu_power");
            if (mp != null) {
                allMenu = getCheckedMenuList(allMenu, mp);
            }
        }
        String build = new JSONUtils().build(allMenu);
        System.out.println(build);
        return build;
    }

    /**
     * 查看菜单id是否存在于menu_power中
     * 如果存在，则将checked标记为true
     */
    private List<Menu> getCheckedMenuList(List<Menu> allMenu, Object mp) {
        BigInteger bigIntegerPower = new BigInteger(mp.toString());
        allMenu.forEach(item -> {
            if (bigIntegerPower.testBit(item.getMid())) {
                item.setChecked(true);
            }
            if (item.getMenuList() != null && item.getMenuList().size() > 0) {
                getCheckedMenuList(item.getMenuList(), mp);
            }
        });
        return allMenu;
    }


}

