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

    /**
     * 将首字母变成大写
     * @param str 需要改变的字符串
     * @return 首字母变大写后的字符串
     */
    public static String capitalize(final String str) {
        if (isBlank(str)) {
            return str;
        }

        final char firstChar = str.charAt(0);
        if (Character.isTitleCase(firstChar)) {
            return str;
        }

        return Character.toTitleCase(firstChar) + str.substring(1);
    }
}
