package com.hexfa.weather.Model;

import java.util.HashMap;
import java.util.Map;

public class Result<T> {

    public Result()
    {
    }

    public Result(T t)
    {
        data = t;
        Message = "OK";
        OK = true;
    }

    public Result(String msg)
    {
        Message = msg;
        OK = false;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public boolean isOK() {
        return OK;
    }

    public void setOK(boolean OK) {
        this.OK = OK;
    }

    private T data;
    private String Message;
    private boolean OK;
}
