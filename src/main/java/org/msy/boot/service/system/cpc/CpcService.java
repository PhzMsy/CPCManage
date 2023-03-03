package org.msy.boot.service.system.cpc;

import com.baomidou.mybatisplus.extension.service.IService;
import org.msy.boot.entity.Cpc;
import org.msy.boot.entity.CpcDetail;
import org.msy.boot.entity.FuzzyQuery;

import java.util.List;

/**
 * @author 11612
 * @date 2023/2/28
 */
public interface CpcService extends IService<Cpc> {

    List<CpcDetail> queryCpcList();

    int updateAll(Cpc cpc);

    List<CpcDetail> fuzzyQuery(FuzzyQuery fuzzyQuery);
}
