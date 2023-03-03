package org.msy.boot.service.system.company.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.msy.boot.entity.Company;
import org.msy.boot.mapper.CompanyMapper;
import org.msy.boot.service.system.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 11612
 * @date 2023/3/2
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService  {
    @Autowired
    private CompanyMapper companyMapper;
    @Override
    public int updateAllComp(Company cpcComid) {
        return companyMapper.updateById(cpcComid);
    }
}
