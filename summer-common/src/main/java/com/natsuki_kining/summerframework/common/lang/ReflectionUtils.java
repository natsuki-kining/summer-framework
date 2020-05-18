package com.natsuki_kining.summerframework.common.lang;

import com.esotericsoftware.reflectasm.FieldAccess;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 反射工具类
 *
 * @author : natsuki_kining
 * @version : 1.0.0
 * @date : 2020/5/18 23:49
 * @since : 1.8+
 */
public class ReflectionUtils {


    public static Object getFieldValue(Object object, String fieldName) {
        Assert.notNull(object, "object 不能为空");
        FieldAccess fieldAccess = FieldAccess.get(object.getClass());
        return fieldAccess.get(object, fieldName);
    }

    public static Field findField(Class<?> clazz, String fieldName) {
        Assert.isNotBlank(fieldName, "fieldName 不能为空");
        FieldAccess fieldAccess = FieldAccess.get(clazz);
        Field[] fields = fieldAccess.getFields();
        if (CollectionUtils.isNotBlank(fields)) {
            for (Field field : fields) {
                if (fieldName.equals(field.getName())) {
                    return field;
                }
            }
        }
        return null;
    }

    public static List<Field> findFields(Class<?> clazz, Class<?> fieldType) {
        Assert.notNull(clazz, "clazz 不能为空");
        Assert.notNull(fieldType, "fieldType 不能为空");
        FieldAccess fieldAccess = FieldAccess.get(clazz);
        List<Field> fieldList = null;
        Field[] fields = fieldAccess.getFields();
        if (CollectionUtils.isNotBlank(fields)) {
            fieldList = new ArrayList<>();
            for (Field field : fields) {
                if (fieldType == field.getType()) {
                    fieldList.add(field);
                }
            }
        }
        return fieldList;
    }

    public static Field findField(Class<?> clazz, Class<?> fieldType) {
        List<Field> fields = findFields(clazz, fieldType);
        if (CollectionUtils.isNotBlank(fields)) {
            return fields.get(0);
        }
        return null;
    }


}
