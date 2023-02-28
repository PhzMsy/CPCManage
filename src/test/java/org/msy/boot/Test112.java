package org.msy.boot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.msy.boot.entity.Menu;
import org.msy.boot.entity.Page;
import org.msy.boot.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 11612
 * @date 2023/2/28
 */

@SpringBootTest
public class Test112 {
    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void selectMenuByMid() {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        /*queryWrapper.select("mid","m_name","pid","status","href","p_name","is_deleted");*/
        queryWrapper.select(Menu.class,info-> !info.getColumn().equals("menu_list"));
        queryWrapper.eq("mid", 1);
        queryWrapper.eq("is_deleted", 1);
            Menu menus = menuMapper.selectOne(queryWrapper);
        System.out.println(menus.toString());
    }

}
