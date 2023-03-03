package org.msy.boot.service.system.edu;

import com.baomidou.mybatisplus.extension.service.IService;
import org.msy.boot.entity.Edu;

/**
 * @author 11612
 * @date 2023/3/2
 */
public interface EduService extends IService<Edu> {
    int updateAllEdu(Edu edu);
}
