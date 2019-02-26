package com.shareholdergame.engine.account.service;

import com.shareholdergame.engine.account.api.AccountOperations;
import com.shareholdergame.engine.account.api.ChangePassword;
import com.shareholdergame.engine.account.api.SignUp;
import com.shareholdergame.engine.account.dao.AccountDao;
import com.shareholdergame.engine.account.dao.AccountOperationDao;
import com.shareholdergame.engine.account.dao.Transactional;
import com.shareholdergame.engine.account.model.*;
import com.shareholdergame.engine.common.event.BusinessEvent;
import com.shareholdergame.engine.common.event.BusinessEventType;
import com.shareholdergame.engine.common.util.IdentifierHelper;
import com.shareholdergame.engine.common.util.MD5Helper;
import com.shareholdergame.engine.common.util.RandomStringGenerator;
import io.micronaut.context.event.ApplicationEventPublisher;
import io.micronaut.http.annotation.Controller;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller("/account")
public class AccountService implements AccountOperations {

    @Inject
    private AccountDao accountDao;

    @Inject
    private AccountOperationDao accountOperationDao;

    @Inject
    private ApplicationEventPublisher eventPublisher;

    @Override
    public boolean checkUserExistence(String userNameOrEmail) {
        return null != accountDao.checkUserExistence(userNameOrEmail);
    }

    @Override
    public AccountWithPassword findUserByNameOrEmail(String userNameOrEmail) {
        return accountDao.findByUserNameOrEmail(userNameOrEmail);
    }

    @Override
    @Transactional
    public void createAccount(SignUp signUp) {
        Long gamerId = IdentifierHelper.generateLongId();
        GamerAccount gamerAccount = GamerAccount.builder()
                .id(gamerId)
                .userName(signUp.getUserName())
                .email(signUp.getEmail())
                .status(AccountStatus.NEW)
                .creationDate(LocalDate.now())
                .language(signUp.getLanguage())
                .build();

        accountDao.insertAccount(AccountWithPassword.builder()
                .account(gamerAccount)
                .password(MD5Helper.generateMD5hashWithSalt(signUp.getPassword())).build());

        accountOperationDao.insertOperation(AccountOperation.builder()
                .gamerId(gamerId)
                .operationType(AccountOperationType.CHANGE_STATUS)
                .oldValue(AccountStatus.NEW.name())
                .newValue(AccountStatus.ACTIVE.name())
                .verificationCode(RandomStringGenerator.generate(4))
                .initiationDate(LocalDateTime.now())
                .operationStatus(AccountOperationStatus.VERIFICATION_PENDING)
                .build()
        );

        eventPublisher.publishEvent(BusinessEvent.of(BusinessEventType.ACCOUNT_CREATED, gamerAccount));
    }

    @Override
    public void changePassword(ChangePassword changePassword) {

    }
}
