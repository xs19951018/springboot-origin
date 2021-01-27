package com.my.springbootorigin.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.my.springbootorigin.common.annontations.WrapperConst;
import com.my.springbootorigin.common.annontations.WrapperInfo;
import org.springframework.util.StringUtils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PageQueryUtils {

    public static <Q> QueryWrapper getWrapper(Q reqBody) {
        QueryWrapper<Object> queryWrapper = new QueryWrapper();

        Class c = reqBody.getClass();
        while (c != null) {
            Field[] fields = c.getDeclaredFields();
            for (Field f : fields) {
                try {
                    f.setAccessible(true);
                    WrapperInfo wrapperInfo = f.getAnnotation(WrapperInfo.class);
                    if (wrapperInfo == null) continue;

                    String name = f.getName();
                    Class<?> type = f.getType();
                    Object value = f.get(reqBody);

                    String fieldName = name;
                    if (StringUtils.hasLength(wrapperInfo.field())) {
                        fieldName = wrapperInfo.field();
                    }
                    if (StringUtils.hasLength(wrapperInfo.table())) {
                        fieldName = wrapperInfo.table() + "." + fieldName;
                    }

                    if (value == null
                            || (type == String.class && !StringUtils.hasLength((String) value))) {     // 值为空，不做筛选
                        continue;
                    }

                    switch (wrapperInfo.value()) {
                        case WrapperConst.EQUALS:
                            queryWrapper.eq(fieldName, value);
                            break;
                        case WrapperConst.LIKE:
                            if (type == String.class) {     // 只有String能做模糊筛选
                                queryWrapper.like(fieldName, (String) value);
                            }
                            break;
                        case WrapperConst.BETWEEN:
                            if (type.isArray()) {   // 数组类型
                                if (Array.getLength(value) < 2) continue;
                                queryWrapper.between(fieldName, Array.get(value, 0), Array.get(value, 1));
                            }
                            if (type == List.class || type == ArrayList.class || type == LinkedList.class) {    // list类型
                                List valueList = (List) value;
                                if (valueList.size() < 2) continue;
                                queryWrapper.between(fieldName, valueList.get(0), valueList.get(1));
                            }
                            break;
                        case WrapperConst.GREATER:
                            queryWrapper.gt(fieldName, value);
                            break;
                        case WrapperConst.GREATER_OR_EQUALS:
                            queryWrapper.ge(fieldName, value);
                            break;
                        case WrapperConst.LESS:
                            queryWrapper.lt(fieldName, value);
                            break;
                        case WrapperConst.LESS_OR_EQUALS:
                            queryWrapper.le(fieldName, value);
                            break;
                        case WrapperConst.OR:
                            if (!StringUtils.hasLength(wrapperInfo.field())) break;
                            String[] fieldNames = wrapperInfo.field().split(",");
                            if (fieldNames.length == 0) break;

                            String tableName = StringUtils.hasLength(wrapperInfo.table()) ? wrapperInfo.table() + "." : "";
                            queryWrapper.and(wrapper -> {
                                wrapper.eq(tableName + fieldNames[0], value);
                                for (int i = 1; i < fieldNames.length; i++) {
                                    wrapper.or().eq(tableName + fieldNames[i], value);
                                }
                            });
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            c = c.getSuperclass();
        }
        return queryWrapper;
    }
}
