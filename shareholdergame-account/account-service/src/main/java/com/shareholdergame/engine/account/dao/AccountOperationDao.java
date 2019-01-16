package com.shareholdergame.engine.account.dao;

import javax.inject.Singleton;

import com.shareholdergame.engine.account.dao.mapper.AccountOperationMapper;
import com.shareholdergame.engine.account.model.AccountOperation;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Date: 01/16/2019
 *
 * @author Aliaksandr Savin
 */
@Singleton
public class AccountOperationDao implements AccountOperationMapper {

    private final SqlSessionFactory sqlSessionFactory;

    public AccountOperationDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void insertOperation(AccountOperation accountOperation) {

    }
}
