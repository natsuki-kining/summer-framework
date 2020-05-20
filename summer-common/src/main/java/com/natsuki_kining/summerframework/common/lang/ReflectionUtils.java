package com.natsuki_kining.summerframework.common.lang;

import com.esotericsoftware.reflectasm.FieldAccess;
import com.esotericsoftware.reflectasm.MethodAccess;

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

    private static final String GETTER_PREFIX = "get";
    private static final String SETTER_PREFIX = "set";

    /**
     * 根据属性名获取对应的值
     * @param object 获取值的对象
     * @param fieldName 属性名
     * @return 属性值
     */
    public static Object getFieldValue(Object object, String fieldName) {
        Assert.notNull(object, "object 不能为空");
        FieldAccess fieldAccess = FieldAccess.get(object.getClass());
        return fieldAccess.get(object, fieldName);
    }

    /**
     * 获取根据属性名属性对象
     * @param clazz 或许的类
     * @param fieldName 属性名
     * @return 属性
     */
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

    /**
     * 根据属性类型获取属性对象集合
     * @param clazz 获取的类
     * @param fieldType 属性类型
     * @return 属性集合
     */
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

    /**
     * 根据属性类型获取属性对象
     * @param clazz 获取的类
     * @param fieldType 属性类型
     * @return 属性
     */
    public static Field findField(Class<?> clazz, Class<?> fieldType) {
        List<Field> fields = findFields(clazz, fieldType);
        if (CollectionUtils.isNotBlank(fields)) {
            return fields.get(0);
        }
        return null;
    }

    /**
     * 通过方法名直接调用方法
     * @param object 调用的对象
     * @param methodName 方法名
     * @param params 参数
     * @return 方法返回值
     */
    public static Object invoke(Object object,String methodName,Object ... params){
        Assert.notNull(object,"object 不能为空");
        Assert.isNotBlank(methodName,"方法名不能为空");
        MethodAccess methodAccess = MethodAccess.get(object.getClass());
        return methodAccess.invoke(object, methodName, params);
    }

    /**
     * 调用属性名的set方法
     * @param object 对象
     * @param fieldName 属性名
     * @param param 要设置的值
     */
    public static void invokeSet(Object object,String fieldName,Object param){
        Assert.notNull(object,"object 不能为空");
        Assert.isNotBlank(fieldName,"属性名不能为空");
        String capitalize = SETTER_PREFIX + StringUtils.capitalize(fieldName);
        invoke(object,capitalize,param);
    }

    /**
     * 调用属性名的get方法
     * @param object 要调用的对象
     * @param fieldName 属性名
     * @return get的返回值
     */
    public static Object invokeGet(Object object,String fieldName){
        Assert.notNull(object,"object 不能为空");
        Assert.isNotBlank(fieldName,"属性名不能为空");
        String capitalize = GETTER_PREFIX + StringUtils.capitalize(fieldName);
        return invoke(object,capitalize);
    }
}
