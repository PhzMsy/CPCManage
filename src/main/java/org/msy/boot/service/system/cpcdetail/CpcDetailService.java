package org.msy.boot.service.system.cpcdetail;

import com.baomidou.mybatisplus.extension.service.IService;
import org.msy.boot.entity.CpcDetail;
import org.msy.boot.entity.Menu;

import java.util.List;

/**
 * @author 11612
 * @date 2023/2/28
 */
public interface CpcDetailService extends IService<CpcDetail> {

    CpcDetail queryById(Integer id);
}
