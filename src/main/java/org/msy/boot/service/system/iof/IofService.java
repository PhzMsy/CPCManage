package org.msy.boot.service.system.iof;

import com.baomidou.mybatisplus.extension.service.IService;
import org.msy.boot.entity.Company;
import org.msy.boot.entity.Iof;

/**
 * @author 11612
 * @date 2023/3/2
 */
public interface IofService extends IService<Iof> {
    int updateAllIof(Iof iof);
}
