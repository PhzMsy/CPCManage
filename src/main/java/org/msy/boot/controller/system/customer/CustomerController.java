package org.msy.boot.controller.system.customer;

import org.msy.boot.entity.Customer;
import org.msy.boot.service.system.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 11612
 * @date 2023/3/7
 */
@Controller
@RequestMapping("/custom")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/list")
    public String list(Model model) {
        List<Customer> list = customerService.queryCustomer();
        model.addAttribute("list", list);
        return "/customer/customerList";
    }
    @RequestMapping("/updateById")
    public String updateById(Customer customer,Model model) {
        Customer list = customerService.queryByCustomerId(customer.getId());
        model.addAttribute("list", list);
        return "/customer/customerUpdate";
    } @RequestMapping("/queryById")
    public String queryById(Customer customer,Model model) {
        Customer list = customerService.queryByCustomerId(customer.getId());
        model.addAttribute("list", list);
        return "/customer/customerDetail";
    }
}
