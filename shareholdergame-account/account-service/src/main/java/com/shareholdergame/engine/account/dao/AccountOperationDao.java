package com.shareholdergame.engine.account.dao;

import com.shareholdergame.engine.account.dao.mapper.AccountOperationMapper;
import com.shareholdergame.engine.account.model.AccountOperation;
import com.shareholdergame.engine.account.model.AccountOperationStatus;
import com.shareholdergame.engine.common.sql.BaseDao;
import org.apache.ibatis.session.SqlSessionManager;

import javax.inject.Singleton;
import java.time.LocalDateTime;

/**
 * Date: 01/16/2019
 *
 * @author Aliaksandr Savin
 */
@Singleton
public class AccountOperationDao extends BaseDao<AccountOperationMapper> implements AccountOperationMapper {

    public AccountOperationDao(SqlSessionManager sqlSessionManager) {
        super(sqlSessionManager);
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
    public void updateStatus(AccountOperation accountOperation) {
        getMapper().updateStatus(accountOperation);
    }
}
