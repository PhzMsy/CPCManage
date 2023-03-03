package org.msy.boot.service.system.company;

import com.baomidou.mybatisplus.extension.service.IService;
import org.msy.boot.entity.Company;
import org.msy.boot.entity.Cpc;

/**
 * @author 11612
 * @date 2023/3/2
 */
public interface CompanyService extends IService<Company> {

    int updateAllComp(Company cpcComid);
}
