package org.msy.boot.service.system.party.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.msy.boot.entity.Party;
import org.msy.boot.mapper.PartyMapper;
import org.msy.boot.service.system.party.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 11612
 * @date 2023/3/2
 */
@Service
public class PartyServiceImpl extends ServiceImpl<PartyMapper, Party> implements PartyService {
    @Autowired
    private PartyMapper partyMapper;
    @Override
    public int updateAllParty(Party cpcParid) {
        return partyMapper.updateById(cpcParid);
    }
}
