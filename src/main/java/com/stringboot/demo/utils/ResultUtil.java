package com.stringboot.demo.utils;

import com.stringboot.demo.help.Result;

/**
 * Created with IntelliJ IDEA
 * Created by xuyf
 * Date 2017/12/15
 * Time 17:09
 */
public class ResultUtil {
    public static Result success(Object object)
    {
        Result result=new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }
    public static Result success()
    {
        return success(null);
    }
    public static Result error(Integer code,String msg)
    {
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
