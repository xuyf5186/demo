package com.stringboot.demo.reposity;

import com.stringboot.demo.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA
 * Created by xuyf
 * Date 2017/12/14
 * Time 15:51
 */

public interface AccountReposity extends JpaRepository<AccountEntity, Integer> {
}
