package org.msy.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.msy.boot.entity.Menu;
import org.msy.boot.entity.Page;

import java.util.List;

/**
 * @author 11612
 * @date 2023/2/27
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> getAllMenu(int i);

    List<Menu> getMenuList(Page<Menu> page);

    Integer getCount(Menu t);

    void deleteMenu(Integer mid);

    void deleteBatchMenu(String check);

    Integer updateMenu(Menu menu);
}
