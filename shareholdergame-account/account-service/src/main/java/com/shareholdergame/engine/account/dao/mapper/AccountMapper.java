package com.shareholdergame.engine.account.dao.mapper;

import com.shareholdergame.engine.account.model.AccountStatus;
import com.shareholdergame.engine.account.model.GamerAccount;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {

    GamerAccount findByUniqueIds(@Param("gamerId") Long gamerId, @Param("userNameOrEmail") String userNameOrEmail);

    Long checkUserExistence(@Param("userNameOrEmail") String userNameOrEmail, @Param("gamerId") Long gamerId);

    void insertAccount(GamerAccount gamerAccount);

    void updatePassword(@Param("gamerId") Long gamerId, @Param("password") String newPassword);

    void updateEmail(@Param("gamerId") Long gamerId, @Param("email") String newEmail);

    void updateStatus(@Param("gamerId") Long gamerId, @Param("status") AccountStatus newStatus);

    void updateUserName(@Param("gamerId") Long gamerId, @Param("userName") String newUserName);
}
