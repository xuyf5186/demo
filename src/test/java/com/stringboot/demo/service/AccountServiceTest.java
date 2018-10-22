package com.stringboot.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA
 * Created by xuyf
 * Date 2017/12/18
 * Time 17:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountServiceTest {
    @Autowired
    private AccountService accountService;
    @Test
    public void findAll() throws Exception {
        System.out.println(accountService.findAll());
    }

    @Test
    public void add() throws Exception {
    }

}