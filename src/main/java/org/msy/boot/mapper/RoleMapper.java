package org.msy.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.msy.boot.entity.Role;

import java.util.List;
import java.util.Map;

/**
 * @author 11612
 * @date 2023/3/8
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    List<Map<String, Object>> findPower(Integer rid);

    int savePower(Map<String, Object> powerMap);

    Integer findPowerByRid(Integer rid);

    Integer saveNewPower(Map<String, Object> powerMap);

    @Update("update sys_role set pid = #{pid} where rid = #{rid}")
    Integer updateRoleByRid(Map<String, Object> powerMap);
}
