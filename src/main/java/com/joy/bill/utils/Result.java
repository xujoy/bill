package com.joy.bill.utils;

/**
 * Created by joy on 2018/3/29.
 */
public class Result<T> {

    int code;
    String message;
    T data;

    public Result() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}