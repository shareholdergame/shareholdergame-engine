package com.shareholdergame.engine.account.dao.mapper;

import com.shareholdergame.engine.account.model.AccountWithPassword;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {

    AccountWithPassword findByUniqueIds(@Param("gamerId") Long gamerId, @Param("userNameOrEmail") String userNameOrEmail);

    Long checkUserExistence(@Param("userNameOrEmail") String userNameOrEmail, @Param("gamerId") Long gamerId);

    void insertAccount(AccountWithPassword accountWithPassword);

    void updatePassword(@Param("gamerId") Long gamerId, @Param("password") String newPassword);
}
