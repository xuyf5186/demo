package com.stringboot.demo.controller;

import com.stringboot.demo.entity.AccountEntity;
import com.stringboot.demo.help.Result;
import com.stringboot.demo.reposity.AccountReposity;
import com.stringboot.demo.service.AccountService;
import com.stringboot.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created by xuyf
 * Date 2017/12/13
 * Time 20:57
 */
@RestController
public class IndexController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public String index()
    {
        return "请求成功";
    }
    @RequestMapping(value="/user",method = RequestMethod.GET)
    public Result getList()
    {
        return ResultUtil.success(accountService.findAll());
    }
    @PostMapping("/user")
    public Result add(@Validated AccountEntity account, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());

        return ResultUtil.success(accountService.add(account));
    }
}
