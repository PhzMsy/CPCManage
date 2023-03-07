package org.msy.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.msy.boot.entity.Customer;

/**
 * @author 11612
 * @date 2023/3/7
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
}
