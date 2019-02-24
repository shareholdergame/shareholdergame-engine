package com.shareholdergame.engine.account.dao;

import com.shareholdergame.engine.account.dao.mapper.AccountMapper;
import com.shareholdergame.engine.account.model.AccountWithPassword;
import org.apache.ibatis.session.SqlSessionManager;

import javax.inject.Singleton;

@Singleton
public class AccountDao implements AccountMapper {

    private final SqlSessionManager sqlSessionManager;

    public AccountDao(SqlSessionManager sqlSessionManager) {
        this.sqlSessionManager = sqlSessionManager;
    }

    @Override
    public AccountWithPassword findByUserNameOrEmail(String userNameOrEmail) {
        return sqlSessionManager.getMapper(AccountMapper.class).findByUserNameOrEmail(userNameOrEmail);
    }

    @Override
    public Long checkUserExistence(String userNameOrEmail) {
        return sqlSessionManager.getMapper(AccountMapper.class).checkUserExistence(userNameOrEmail);
    }

    public void insertAccount(AccountWithPassword accountWithPassword) {
        sqlSessionManager.getMapper(AccountMapper.class).insertAccount(accountWithPassword);
    }
}
