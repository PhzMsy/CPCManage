package org.msy.boot.service.system.menu.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.msy.boot.entity.Menu;
import org.msy.boot.entity.Page;
import org.msy.boot.mapper.MenuMapper;
import org.msy.boot.service.system.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 11612
 * @date 2023/2/27
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getAllMenu(int i) {
        return menuMapper.getAllMenu(i);
    }

    @Override
    public Page getMenuList(Page<Menu> page) {
        // 分页数据查询
        List<Menu> menuList = menuMapper.getMenuList(page);
        // 总记录数查询
        Integer count = menuMapper.getCount(page.getT());
        page.setCount(count);
        page.setData(menuList);
        return page;
    }

    @Override
    public Menu selectMenuByMid(Integer mid) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.select(Menu.class, info -> !info.getColumn().equals("menu_list"));
        queryWrapper.eq("mid", mid);
        queryWrapper.eq("is_deleted", 1);
        Menu menus = menuMapper.selectOne(queryWrapper);
        return menus;
    }

    @Override
    public List<Menu> selectParentMenu() {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.select(Menu.class, info -> !info.getColumn().equals("menu_list"));
        queryWrapper.eq("pid", 0);
        queryWrapper.eq("is_deleted", 1);
        queryWrapper.eq("status", 1);
        List<Menu> menu = menuMapper.selectList(queryWrapper);
        return menu;
    }

    @Override
    public Integer updateMenu(Menu menu) {
        return menuMapper.updateMenu(menu);
    }

    @Override
    public void deleteMenu(Integer mid) {
        // 逻辑删除 更改is_delete属性为0
        menuMapper.deleteMenu(mid);
    }

    @Override
    public void deleteBatchMenu(String check) {
        menuMapper.deleteBatchMenu(check);
    }
}
