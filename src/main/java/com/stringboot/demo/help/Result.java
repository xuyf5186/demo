package com.stringboot.demo.help;

/**
 * Created with IntelliJ IDEA
 * Created by xuyf
 * Date 2017/12/15
 * Time 17:10
 */
public class Result<T> {
    //0 或者 错误码
    private Integer code;
    //成功 或者 失败信息
    private String msg;
    //携带信息
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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
}
