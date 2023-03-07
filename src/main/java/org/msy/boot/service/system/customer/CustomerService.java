package org.msy.boot.service.system.customer;

import com.baomidou.mybatisplus.extension.service.IService;
import org.msy.boot.entity.CpcDetail;
import org.msy.boot.entity.Customer;

import java.util.List;

/**
 * @author 11612
 * @date 2023/3/7
 */
public interface CustomerService extends IService<Customer> {
    List<Customer> queryCustomer();

    Customer queryByCustomerId(Integer id);
}
