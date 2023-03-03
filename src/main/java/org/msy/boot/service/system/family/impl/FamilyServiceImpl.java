package org.msy.boot.service.system.family.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.msy.boot.entity.Family;
import org.msy.boot.mapper.FamilyMapper;
import org.msy.boot.service.system.family.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 11612
 * @date 2023/3/2
 */
@Service
public class FamilyServiceImpl extends ServiceImpl<FamilyMapper, Family> implements FamilyService {
    @Autowired
    private FamilyMapper familyMapper;
    @Override
    public void updateAllFam(Family family) {
        familyMapper.updateById(family);
    }
}
