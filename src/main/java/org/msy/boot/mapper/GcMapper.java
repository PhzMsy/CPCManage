package org.msy.boot.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.msy.boot.entity.Gc;

import java.util.List;
import java.util.Map;

/**
 * @author 11612
 * @date 2023/3/6
 */
@Mapper
public interface GcMapper {
    @MapKey(value = "uid")
    List<Map<String,Object>> getGc();

    int recoverData(Gc gc);

    void finalDelete(Gc gc);
}
