package org.msy.boot.service.system.cpcdetail.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.msy.boot.entity.*;
import org.msy.boot.mapper.*;
import org.msy.boot.service.system.cpc.CpcService;
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
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private CpcMapper cpcMapper;
    @Autowired
    private EduMapper eduMapper;
    @Autowired
    private FamilyMapper familyMapper;
    @Autowired
    private IofMapper iofMapper;
    @Autowired
    private PartyMapper partyMapper;

    @Override
    public CpcDetail queryById(Integer id) {
        return cpcDetailMapper.queryById(id);
    }

    @Override
    public int updateAllData(CpcDetail detail) {
        return cpcDetailMapper.updateById(detail);
    }

    @Override
    public int updateAllParty(Party cpcParid, Integer cpcId) {
        Integer parId = cpcParid.getParId();
        return cpcDetailMapper.updateForParId(parId, cpcId);
    }

    @Override
    public int insertAll(CpcDetail detail) {
        Party cpcParid = detail.getCpcParid();
        String parName = cpcParid.getParName();
        List<Party> parties = partyMapper.selectList(null);
        Integer parId = 1;
        for (Party party : parties){
            if (party.getParName()!=null&&party.getParName().equals(parName)){
                parId = party.getParId();
            }else {
                parId = 1;
            }
        }
        cpcDetailMapper.insert(detail);
        Integer cpcId = detail.getCpcId();
        /**
         * cpc内无cpcId 设置一个
         */
        Cpc cpc = detail.getCpc();
        cpc.setCpcId(cpcId);
        cpcMapper.insert(cpc);

        Edu edu = detail.getEdu();
        edu.setEduId(cpcId);
        eduMapper.insert(edu);

        Iof iof = detail.getIof();
        iof.setIofId(cpcId);
        iofMapper.insert(iof);

        Company cpcComid = detail.getCpcComid();
        cpcComid.setComId(cpcId);
        companyMapper.insert(cpcComid);

        List<Family> familyList = detail.getFamilyList();

        for (Family family : familyList){
            if (family.getFaName()!=null && !family.getFaName().equals("")){
                family.setFaCpcid(cpcId);
                familyMapper.insert(family);
            }
        }
        return 1;
    }
}
