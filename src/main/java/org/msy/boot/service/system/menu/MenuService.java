package org.msy.boot.service.system.menu;


import com.baomidou.mybatisplus.extension.service.IService;
import org.msy.boot.entity.Menu;
import org.msy.boot.entity.Page;

import java.util.List;

/**
 * @author 11612
 * @date 2023/2/27
 */
public interface MenuService extends IService<Menu> {
    List<Menu> getAllMenu(int i);

    Page getMenuList(Page<Menu> page);

    Menu selectMenuByMid(Integer mid);

    List<Menu> selectParentMenu();

    Integer updateMenu(Menu menu);

    void deleteMenu(Integer mid);

    void deleteBatchMenu(String check);
}
