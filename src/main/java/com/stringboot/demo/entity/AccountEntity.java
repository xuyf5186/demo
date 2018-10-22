package com.stringboot.demo.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * Created with IntelliJ IDEA
 * Created by xuyf
 * Date 2017/12/13
 * Time 22:41
 */
@Entity(name = "accounts")
public class AccountEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    @Min(value = 0,message = "余额不能为负数")
    private Double money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    private byte[] avatar;
}
