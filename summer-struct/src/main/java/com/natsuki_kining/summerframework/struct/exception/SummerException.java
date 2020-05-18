package com.natsuki_kining.summerframework.struct.exception;

/**
 * 顶层异常类
 *
 * @author : natsuki_kining
 * @date : 2020/5/18 23:59
 * @version : 1.0.0
 * @since : 1.8+
 */
public class SummerException extends RuntimeException {

    public SummerException(String message) {
        super(message);
    }

    public SummerException(String message,Exception e){
        super(message,e);
    }
}
