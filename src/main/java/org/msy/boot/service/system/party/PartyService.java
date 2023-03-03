package org.msy.boot.service.system.party;

import com.baomidou.mybatisplus.extension.service.IService;
import org.msy.boot.entity.Party;

/**
 * @author 11612
 * @date 2023/3/2
 */
public interface PartyService extends IService<Party> {
    int updateAllParty(Party cpcParid);
}
