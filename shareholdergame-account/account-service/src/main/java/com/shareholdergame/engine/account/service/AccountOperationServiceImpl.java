package com.shareholdergame.engine.account.service;

import com.shareholdergame.engine.account.dao.AccountOperationDao;
import com.shareholdergame.engine.account.model.AccountOperation;
import com.shareholdergame.engine.account.model.AccountOperationStatus;
import com.shareholdergame.engine.api.account.AccountOperationService;
import io.micronaut.http.annotation.Controller;

import javax.inject.Inject;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Controller("/account/operation")
public class AccountOperationServiceImpl implements AccountOperationService {

    @Inject
    private AccountOperationDao accountOperationDao;

    @Override
    public void markVerified(@NotNull Long operationId) {
        accountOperationDao.updateStatus(operationId, AccountOperationStatus.COMPLETED, LocalDateTime.now());
    }

    @Override
    public AccountOperation getOperation(@NotNull Long gamerId, @NotBlank String verificationCode) {
        return accountOperationDao.findByGamerIdAndVerificationCode(gamerId, verificationCode);
    }
}
