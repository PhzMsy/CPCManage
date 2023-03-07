package org.msy.boot.service.system.customer.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.msy.boot.entity.CpcDetail;
import org.msy.boot.entity.Customer;
import org.msy.boot.mapper.CpcDetailMapper;
import org.msy.boot.mapper.CustomerMapper;
import org.msy.boot.service.system.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 11612
 * @date 2023/3/7
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public List<Customer> queryCustomer() {
        List<Customer> customers = customerMapper.selectList(null);
        return customers;
    }

    @Override
    public Customer queryByCustomerId(Integer id) {
        QueryWrapper<Customer> customerQueryWrapper = new QueryWrapper<>();
        customerQueryWrapper.eq("id",id);
        Customer customer = customerMapper.selectOne(customerQueryWrapper);
        return customer;
    }
}
