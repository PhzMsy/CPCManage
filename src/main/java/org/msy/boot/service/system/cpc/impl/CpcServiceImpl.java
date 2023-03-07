package org.msy.boot.service.system.cpc.impl;

import com.alibaba.druid.sql.visitor.functions.If;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.msy.boot.entity.Cpc;
import org.msy.boot.entity.CpcDetail;
import org.msy.boot.entity.FuzzyQuery;
import org.msy.boot.entity.Party;
import org.msy.boot.mapper.CpcMapper;
import org.msy.boot.mapper.PartyMapper;
import org.msy.boot.service.system.cpc.CpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 11612
 * @date 2023/2/28
 */
@Service
public class CpcServiceImpl extends ServiceImpl<CpcMapper, Cpc> implements CpcService {

    @Autowired
    private CpcMapper cpcMapper;
    @Autowired
    private PartyMapper partyMapper;

    @Override
    public List<CpcDetail> queryCpcList() {
        return cpcMapper.queryAll();
    }

    @Override
    public int updateAll(Cpc cpc) {
        return cpcMapper.updateById(cpc);
    }

    @Override
    public List<CpcDetail> fuzzyQuery(FuzzyQuery fuzzyQuery) {
        QueryWrapper<Party> partyQueryWrapper = new QueryWrapper<>();

        List<CpcDetail> list = new ArrayList<>();
        String startDate = fuzzyQuery.getStartDate();
        String endDate = fuzzyQuery.getEndDate();
        if (startDate!=null){
            partyQueryWrapper.ge("start_date",startDate);
        }
        if (endDate!=null){
            partyQueryWrapper.ge("end_date",endDate);
        }

        if (fuzzyQuery.getFuzzyParty() != null && !fuzzyQuery.getFuzzyParty().equals("")) {
            partyQueryWrapper.select("par_id").like("par_name", fuzzyQuery.getFuzzyParty());
            List<Party> parties = partyMapper.selectList(partyQueryWrapper);
            for (Party party : parties) {
                Integer parId = party.getParId();
                fuzzyQuery.setFuzzyParty(String.valueOf(parId));
                if (cpcMapper.fuzzyQuery(fuzzyQuery)!=null){
                    list.addAll(cpcMapper.fuzzyQuery(fuzzyQuery));
                }
            }
        } else {
            list = cpcMapper.fuzzyQuery(fuzzyQuery);
        }
        return list;
    }
}
