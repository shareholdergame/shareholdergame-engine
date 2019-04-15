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
    public AccountWithPassword findByUniqueIds(Long gamerId, String userNameOrEmail) {
        return sqlSessionManager.getMapper(AccountMapper.class).findByUniqueIds(gamerId, userNameOrEmail);
    }

    @Override
    public Long checkUserExistence(String userNameOrEmail, Long gamerId) {
        return sqlSessionManager.getMapper(AccountMapper.class).checkUserExistence(userNameOrEmail, gamerId);
    }

    public void insertAccount(AccountWithPassword accountWithPassword) {
        sqlSessionManager.getMapper(AccountMapper.class).insertAccount(accountWithPassword);
    }

    @Override
    public void updatePassword(Long gamerId, String newPassword) {
        sqlSessionManager.getMapper(AccountMapper.class).updatePassword(gamerId, newPassword);
    }
}
