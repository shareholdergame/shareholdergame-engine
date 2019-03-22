package com.shareholdergame.engine.account.dao;

import com.shareholdergame.engine.account.dao.mapper.AccountOperationMapper;
import com.shareholdergame.engine.account.model.AccountOperation;
import com.shareholdergame.engine.account.model.AccountOperationStatus;
import org.apache.ibatis.session.SqlSessionManager;

import javax.inject.Singleton;
import java.time.LocalDateTime;

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
        getMapper().insertOperation(accountOperation);
    }

    @Override
    public AccountOperation findByGamerIdAndVerificationCode(Long gamerId, String verificationCode) {
        return getMapper().findByGamerIdAndVerificationCode(gamerId, verificationCode);
    }

    @Override
    public void updateStatus(Long operationId, AccountOperationStatus status, LocalDateTime completionDate) {
        getMapper().updateStatus(operationId, status, completionDate);
    }

    private AccountOperationMapper getMapper() {
        return sqlSessionManager.getMapper(AccountOperationMapper.class);
    }
}
