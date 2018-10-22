package com.stringboot.demo.exception;

/**
 * Created with IntelliJ IDEA
 * Created by xuyf
 * Date 2017/12/15
 * Time 17:58
 */
public class AccountException extends RuntimeException{
    private Integer code;

    public AccountException(Integer code,String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
