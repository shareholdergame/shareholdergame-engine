package com.shareholdergame.engine.account.dao.mapper;

import com.shareholdergame.engine.account.model.AccountOperation;
import org.apache.ibatis.annotations.Param;

/**
 * Date: 01/16/2019
 *
 * @author Aliaksandr Savin
 */
public interface AccountOperationMapper {

    void insertOperation(AccountOperation accountOperation);

    AccountOperation findByGamerIdAndVerificationCode(@Param("gamerId") Long gamerId, @Param("verificationCode") String verificationCode);
}
