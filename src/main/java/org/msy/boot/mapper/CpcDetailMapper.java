package org.msy.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.msy.boot.entity.CpcDetail;

import java.util.List;

/**
 * @author 11612
 * @date 2023/2/28
 */
@Mapper
public interface CpcDetailMapper extends BaseMapper<CpcDetail> {

    CpcDetail queryById(@Param("cpc_id") Integer id);
}
