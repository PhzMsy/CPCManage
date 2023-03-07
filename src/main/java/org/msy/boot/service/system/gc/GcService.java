package org.msy.boot.service.system.gc;

import org.msy.boot.entity.Gc;

import java.util.List;
import java.util.Map;

/**
 * @author 11612
 * @date 2023/3/6
 */
public interface GcService {
    List<Map<String, Object>> getGc() ;

    boolean recoverData(Gc gc);

    void finalDelete(Gc gc);
}
