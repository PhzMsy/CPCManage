package org.msy.boot.service.system.cpc.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.msy.boot.entity.Cpc;
import org.msy.boot.entity.CpcDetail;
import org.msy.boot.mapper.CpcMapper;
import org.msy.boot.service.system.cpc.CpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 11612
 * @date 2023/2/28
 */
@Service
public class CpcServiceImpl extends ServiceImpl<CpcMapper, Cpc> implements CpcService {

    @Autowired
    private CpcMapper cpcMapper;
    @Override
    public List<CpcDetail> queryCpcList() {
        return cpcMapper.queryAll();
    }
}
