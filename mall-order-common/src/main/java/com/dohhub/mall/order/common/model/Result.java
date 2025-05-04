package com.dohhub.mall.order.common.model;

import java.io.Serializable;

/**
 * Created by chenjiacheng on 2025/5/4 23:15
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
public class Result<T> implements Serializable {

    private String code;
    private String msg;

    private T data;

    public Result() {
    }

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public static <T> Result<T> success(T data) {
        return new Result<>("200", "ok", data);
    }
    public static <T> Result<T> error(String code, String msg) {
        return new Result<>(code, msg);
    }





}
