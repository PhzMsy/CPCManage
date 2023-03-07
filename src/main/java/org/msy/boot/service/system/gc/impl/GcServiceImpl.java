package org.msy.boot.service.system.gc.impl;

import org.apache.ibatis.annotations.Mapper;
import org.msy.boot.entity.Gc;
import org.msy.boot.mapper.GcMapper;
import org.msy.boot.service.system.gc.GcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 11612
 * @date 2023/3/6
 */
@Service
public class GcServiceImpl implements GcService {
    @Autowired
    private GcMapper gcMapper;
    @Override
    public List<Map<String, Object>> getGc() {
        return gcMapper.getGc();
    }

    @Override
    public boolean recoverData(Gc gc) {
        int count = gcMapper.recoverData(gc);
        return count > 0;
    }

    @Override
    public void finalDelete(Gc gc) {
        gcMapper.finalDelete(gc);
    }
}
