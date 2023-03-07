package org.msy.boot.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * @author 11612
 * @date 2023/3/6
 */
public class DefaultValueHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("is_deleted",0,metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
