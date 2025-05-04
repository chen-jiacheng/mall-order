package com.dohhub.mall.order.common.exception;

/**
 * Created by chenjiacheng on 2025/5/4 23:17
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
public class BusinessException extends RuntimeException {

    private String code;
    private String msg;

    public BusinessException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
