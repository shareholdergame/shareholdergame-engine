package com.shareholdergame.engine.account.dao;

import com.shareholdergame.engine.account.dao.mapper.AccountOperationMapper;
import com.shareholdergame.engine.account.model.AccountOperation;
import org.apache.ibatis.session.SqlSessionManager;

import javax.inject.Singleton;

/**
 * Date: 01/16/2019
 *
 * @author Aliaksandr Savin
 */
@Singleton
public class AccountOperationDao implements AccountOperationMapper {

    private final SqlSessionManager sqlSessionManager;

    public AccountOperationDao(SqlSessionManager sqlSessionManager) {
        this.sqlSessionManager = sqlSessionManager;
    }

    @Override
    public void insertOperation(AccountOperation accountOperation) {

    }
}
