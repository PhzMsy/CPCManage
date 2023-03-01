package org.msy.boot.service.system.cpcdetail.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.msy.boot.entity.CpcDetail;
import org.msy.boot.mapper.CpcDetailMapper;
import org.msy.boot.service.system.cpcdetail.CpcDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 11612
 * @date 2023/2/28
 */
@Service
public class CpcDetailServiceImpl extends ServiceImpl<CpcDetailMapper, CpcDetail> implements CpcDetailService {

    @Autowired
    private CpcDetailMapper cpcDetailMapper;


    @Override
    public CpcDetail queryById(Integer id) {
        return cpcDetailMapper.queryById(id);
    }
}
