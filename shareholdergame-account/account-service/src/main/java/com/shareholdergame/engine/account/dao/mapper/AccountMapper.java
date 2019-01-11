package com.shareholdergame.engine.account.dao.mapper;

import com.shareholdergame.engine.account.model.AccountWithPassword;

public interface AccountMapper {

    AccountWithPassword findByUserNameOrEmail(String userNameOrEmail);

    Long checkUserExistence(String userNameOrEmail);

    void insertAccount(AccountWithPassword accountWithPassword);
}
