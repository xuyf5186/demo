package com.stringboot.demo.handle;

import com.stringboot.demo.exception.AccountException;
import com.stringboot.demo.help.Result;
import com.stringboot.demo.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA
 * Created by xuyf
 * Date 2017/12/15
 * Time 17:39
 */
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(AccountException e){
        return ResultUtil.error(e.getCode(),e.getMessage());
    }
}
