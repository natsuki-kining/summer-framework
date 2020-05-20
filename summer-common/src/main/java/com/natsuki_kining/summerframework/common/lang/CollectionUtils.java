package com.natsuki_kining.summerframework.common.lang;

import java.util.List;

/**
 * 处理集合的工具类
 *
 * @author : natsuki_kining
 * @date : 2020/5/19 0:23
 * @version : 1.0.0
 * @since : 1.8+
 */
public class CollectionUtils {

    public static boolean isNotBlank(Object[] objects) {
        return !isBlank(objects);
    }

    public static boolean isBlank(Object[] objects) {
        return objects == null || objects.length == 0;
    }

    public static boolean isNotBlank(List<?> objects) {
        return !isBlank(objects);
    }

    public static boolean isBlank(List<?> objects) {
        return objects == null || objects.size() == 0;
    }

    public static boolean isNotEmpty(Object[] objects) {
        return !isEmpty(objects);
    }

    public static boolean isEmpty(Object[] objects) {
        return objects == null;
    }

    public static boolean isNotEmpty(List<?> objects) {
        return !isEmpty(objects);
    }

    public static boolean isEmpty(List<?> objects) {
        return objects == null;
    }
}
