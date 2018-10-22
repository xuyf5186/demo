package com.stringboot.demo.service;

import com.stringboot.demo.entity.AccountEntity;
import com.stringboot.demo.exception.AccountException;
import com.stringboot.demo.reposity.AccountReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created by xuyf
 * Date 2017/12/14
 * Time 17:09
 */
@Service
public class AccountService {
    @Autowired
    private AccountReposity accountReposity;
    public List<AccountEntity> findAll(){
        return accountReposity.findAll();
    }
    public AccountEntity add(AccountEntity accountEntity){
        if (accountEntity.getMoney()>10000d)
            throw new AccountException(100,"你不可能这么有钱，哼");
        return accountReposity.save(accountEntity);
    }
}
