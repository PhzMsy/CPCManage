package org.msy.boot.service.system.family;

import com.baomidou.mybatisplus.extension.service.IService;
import org.msy.boot.entity.Company;
import org.msy.boot.entity.Family;

import java.util.List;

/**
 * @author 11612
 * @date 2023/3/2
 */
public interface FamilyService extends IService<Family> {


    void updateAllFam(Family family);
}
