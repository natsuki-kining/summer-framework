package com.natsuki_kining.summerframework.common.lang;

import com.natsuki_kining.summerframework.struct.exception.ValidateException;

/**
 * 断言工具类
 *
 * @author : natsuki_kining
 * @date : 2020/5/18 23:57
 */
public class Assert {

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new ValidateException(message);
        }
    }

    public static void isTrue(boolean flag, String message) {
        if (!flag) {
            throw new ValidateException(message);
        }
    }

    public static void isNotBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new ValidateException(message);
        }
    }

    public static void isBlank(String str, String message) {
        if (StringUtils.isNotBlank(str)) {
            throw new ValidateException(message);
        }
    }

}
