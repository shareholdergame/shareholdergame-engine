package com.shareholdergame.engine.account.service;

import com.shareholdergame.engine.api.account.AccountService;
import com.shareholdergame.engine.api.account.PasswordUpdate;
import com.shareholdergame.engine.api.account.NewAccount;
import com.shareholdergame.engine.account.config.AccountServiceConfiguration;
import com.shareholdergame.engine.account.dao.AccountDao;
import com.shareholdergame.engine.account.dao.AccountOperationDao;
import com.shareholdergame.engine.account.event.AccountCreatedEvent;
import com.shareholdergame.engine.account.model.AccountOperation;
import com.shareholdergame.engine.account.model.AccountOperationStatus;
import com.shareholdergame.engine.account.model.AccountOperationType;
import com.shareholdergame.engine.account.model.AccountStatus;
import com.shareholdergame.engine.account.model.AccountWithPassword;
import com.shareholdergame.engine.account.model.GamerAccount;
import com.shareholdergame.engine.common.exception.BusinessException;
import com.shareholdergame.engine.common.exception.Errors;
import com.shareholdergame.engine.common.sql.transaction.Transactional;
import com.shareholdergame.engine.common.util.IdentifierHelper;
import com.shareholdergame.engine.common.util.MD5Helper;
import com.shareholdergame.engine.common.util.RandomStringGenerator;
import io.micronaut.context.event.ApplicationEventPublisher;
import io.micronaut.http.annotation.Controller;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Controller("/account")
public class AccountServiceImpl implements AccountService {

    @Inject
    private AccountServiceConfiguration configuration;

    @Inject
    private AccountDao accountDao;

    @Inject
    private AccountOperationDao accountOperationDao;

    @Inject
    private ApplicationEventPublisher eventPublisher;

    @Override
    public boolean checkUserExistence(String userNameOrEmail) {
        return isUserExists(userNameOrEmail);
    }

    @Override
    public AccountWithPassword findUserByNameOrEmail(String userNameOrEmail) {
        return accountDao.findByUniqueIds(null, userNameOrEmail);
    }

    @Override
    @Transactional
    public void createAccount(NewAccount newAccount) {
        if (isUserExists(newAccount.getEmail())) {
            throw new BusinessException(Errors.USER_ALREADY_EXISTS.name());
        }

        Long gamerId = IdentifierHelper.generateLongId();
        LocalDateTime creationDate = LocalDateTime.now();
        GamerAccount gamerAccount = GamerAccount.builder()
                .id(gamerId)
                .userName(newAccount.getUserName())
                .email(newAccount.getEmail())
                .status(AccountStatus.NEW)
                .creationDate(creationDate)
                .language(newAccount.getLanguage())
                .registeredFromIp(newAccount.getIpAddress())
                .build();

        String verificationCode = RandomStringGenerator.generate(configuration.getVerificationCodeLength());
        LocalDateTime expirationDate = creationDate.plusDays(configuration.getVerificationExpirationDays());

        accountDao.insertAccount(AccountWithPassword.builder()
                .account(gamerAccount)
                .password(MD5Helper.generateMD5hashWithSalt(newAccount.getPassword())).build());

        accountOperationDao.insertOperation(AccountOperation.builder()
                .gamerId(gamerId)
                .operationType(AccountOperationType.CHANGE_STATUS)
                .oldValue(AccountStatus.NEW.name())
                .newValue(AccountStatus.ACTIVE.name())
                .verificationCode(verificationCode)
                .initiationDate(creationDate)
                .expirationDate(expirationDate)
                .operationStatus(AccountOperationStatus.VERIFICATION_PENDING)
                .build()
        );

        eventPublisher.publishEvent(AccountCreatedEvent.of(gamerAccount));
    }

    @Override
    public void changePassword(Long gamerId, PasswordUpdate passwordUpdate) {
        AccountWithPassword accountWithPassword = accountDao.findByUniqueIds(gamerId, null);
        if (isPasswordIdentical(passwordUpdate.getOldPassword(), accountWithPassword.getPassword())) {
            accountDao.updatePassword(gamerId, MD5Helper.generateMD5hashWithSalt(passwordUpdate.getNewPassword()));
        } else {
            throw new BusinessException(Errors.INCORRECT_PASSWORD.name());
        }
    }

    @Override
    public void resetPassword(Long gamerId) {
        if (isUserNotExist(gamerId)) {
            throw new BusinessException(Errors.USER_NOT_EXIST.name());
        }

    }

    @Override
    public void verify(@NotNull Long gamerId, @NotNull String verificationCode) {

    }

    private boolean isUserNotExist(Long gamerId) {
        return null == accountDao.checkUserExistence(null, gamerId);
    }

    private boolean isUserExists(String userNameOrEmail) {
        return null != accountDao.checkUserExistence(userNameOrEmail, null);
    }

    private boolean isPasswordIdentical(String secret, String passwordHash) {
        return MD5Helper.checkMD5hash(secret, passwordHash);
    }
}
