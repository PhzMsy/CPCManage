package org.msy.boot.service.system.iof.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.msy.boot.entity.Iof;
import org.msy.boot.mapper.IofMapper;
import org.msy.boot.service.system.iof.IofService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 11612
 * @date 2023/3/2
 */
@Service
public class IofServiceImpl extends ServiceImpl<IofMapper, Iof> implements IofService {
    @Autowired
    private IofMapper iofMapper;

    @Override
    public int updateAllIof(Iof iof) {
        return iofMapper.updateById(iof);
    }
}
