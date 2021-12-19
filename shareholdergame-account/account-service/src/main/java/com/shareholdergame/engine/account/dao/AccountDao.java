package com.shareholdergame.engine.account.dao;

import com.shareholdergame.engine.account.dao.mapper.AccountMapper;
import com.shareholdergame.engine.account.model.AccountStatus;
import com.shareholdergame.engine.account.model.GamerAccount;
import com.shareholdergame.engine.common.sql.BaseDao;
import org.apache.ibatis.session.SqlSessionManager;

import jakarta.inject.Singleton;

@Singleton
public class AccountDao extends BaseDao<AccountMapper> implements AccountMapper {

    protected AccountDao(SqlSessionManager sqlSessionManager) {
        super(sqlSessionManager);
    }

    @Override
    public GamerAccount findByUniqueIds(Long gamerId, String userNameOrEmail) {
        return getMapper().findByUniqueIds(gamerId, userNameOrEmail);
    }

    @Override
    public Long checkUserExistence(String userNameOrEmail, Long gamerId) {
        return getMapper().checkUserExistence(userNameOrEmail, gamerId);
    }

    public void insertAccount(GamerAccount gamerAccount) {
        getMapper().insertAccount(gamerAccount);
    }

    @Override
    public void updatePassword(Long gamerId, String newPassword) {
        getMapper().updatePassword(gamerId, newPassword);
    }

    @Override
    public void updateEmail(Long gamerId, String newEmail) {
        getMapper().updateEmail(gamerId, newEmail);
    }

    @Override
    public void updateStatus(Long gamerId, AccountStatus newStatus) {
        getMapper().updateStatus(gamerId, newStatus);
    }

    @Override
    public void updateUserName(Long gamerId, String newUserName) {
        getMapper().updateUserName(gamerId, newUserName);
    }
}
