package org.msy.boot.service.system.edu.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.msy.boot.entity.Edu;
import org.msy.boot.mapper.EduMapper;
import org.msy.boot.service.system.edu.EduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 11612
 * @date 2023/3/2
 */
@Service
public class EduServiceImpl extends ServiceImpl<EduMapper, Edu> implements EduService {
    @Autowired
    private EduMapper eduMapper;
    @Override
    public int updateAllEdu(Edu edu) {
        return eduMapper.updateById(edu);
    }
}
