package org.msy.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.msy.boot.entity.Cpc;
import org.msy.boot.entity.CpcDetail;

import java.util.List;


/**
 * @author 11612
 * @date 2023/2/28
 */
@Mapper
public interface CpcMapper extends BaseMapper<Cpc>{

    List<CpcDetail> queryAll();

}
