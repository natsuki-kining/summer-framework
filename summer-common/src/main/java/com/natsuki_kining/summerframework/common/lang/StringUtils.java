package com.natsuki_kining.summerframework.common.lang;

/**
 * 字符串工具类
 *
 * @author : natsuki_kining
 * @version : 1.0.0
 * @since : 1.8+
 */
public class StringUtils {

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static boolean isBlank(String str) {
        return isEmpty(str) || str.trim().length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
}
