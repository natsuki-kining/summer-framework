package com.natsuki_kining.summerframework.struct.exception;

/**
 * 校验异常类
 *
 * @author : natsuki_kining
 * @date : 2020/5/18 23:59
 */
public class ValidateException extends SummerException {

    public ValidateException(String message) {
        super(message);
    }

    public ValidateException(String message,Exception e){
        super(message,e);
    }
}
