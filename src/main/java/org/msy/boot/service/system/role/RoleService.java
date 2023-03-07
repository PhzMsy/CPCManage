package org.msy.boot.service.system.role;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.msy.boot.entity.Role;
import org.msy.boot.entity.RoleVo;

import java.util.List;
import java.util.Map;

/**
 * @author 11612
 * @date 2023/3/8
 */
public interface RoleService {
    Page<Role> findRoleList(Integer current, RoleVo roleVo);

    List<Map<String, Object>> findPower(Integer rid);
    boolean savePower(Map<String, Object> powerMap);
    Integer findPowerByRid(Integer rid);
    boolean saveNewPower(Map<String, Object> powerMap);
}
