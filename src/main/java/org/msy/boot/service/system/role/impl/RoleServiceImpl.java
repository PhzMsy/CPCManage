package org.msy.boot.service.system.role.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.msy.boot.entity.Role;
import org.msy.boot.entity.RoleVo;
import org.msy.boot.mapper.RoleMapper;
import org.msy.boot.service.system.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author 11612
 * @date 2023/3/8
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Page<Role> findRoleList(Integer current, RoleVo roleVo) {
        Page<Role> rolePage = new Page<>();
        rolePage.setCurrent(current);
        QueryWrapper<Role> roleQueryWrapper = new QueryWrapper<>();
        if (StringUtils.hasLength(roleVo.getRname())){
            roleQueryWrapper.like("rname",roleVo.getRname());
        }
        return roleMapper.selectPage(rolePage, roleQueryWrapper);
    }

    @Override
    public List<Map<String, Object>> findPower(Integer rid) {
        return roleMapper.findPower(rid);
    }

    @Override
    public boolean savePower(Map<String, Object> powerMap) {
        return roleMapper.savePower(powerMap)>0;
    }

    @Override
    public Integer findPowerByRid(Integer rid) {
        return  roleMapper.findPowerByRid(rid);

    }

    @Override
    public boolean saveNewPower(Map<String, Object> powerMap) {
        // 执行完成后， powerMap中就多了一个pid
        Integer count1 = roleMapper.saveNewPower(powerMap);
        Integer count2 = roleMapper.updateRoleByRid(powerMap);
        if(count1 > 0 && count2 > 0) {
            return true;
        } else {
            return false;
        }
    }
}
