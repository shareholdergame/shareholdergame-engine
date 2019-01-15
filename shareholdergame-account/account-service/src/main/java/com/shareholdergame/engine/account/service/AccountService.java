package com.shareholdergame.engine.account.service;

import java.time.LocalDate;
import java.util.Optional;
import javax.inject.Inject;

import com.shareholdergame.engine.account.api.AccountOperations;
import com.shareholdergame.engine.account.api.ChangePassword;
import com.shareholdergame.engine.account.api.SignUp;
import com.shareholdergame.engine.account.dao.AccountDao;
import com.shareholdergame.engine.account.model.Account;
import com.shareholdergame.engine.account.model.AccountStatus;
import com.shareholdergame.engine.account.model.AccountWithPassword;
import com.shareholdergame.engine.common.exception.BusinessException;
import com.shareholdergame.engine.common.exception.Errors;
import com.shareholdergame.engine.common.util.IdentifierHelper;
import com.shareholdergame.engine.common.util.MD5Helper;
import io.micronaut.http.annotation.Controller;

@Controller("/account")
public class AccountService implements AccountOperations {

    @Inject
    private AccountDao accountDao;

    @Override
    public boolean checkUserExistence(String userNameOrEmail) {
        return null != accountDao.checkUserExistence(userNameOrEmail);
    }

    @Override
    public AccountWithPassword findUserByNameOrEmail(String userNameOrEmail) {
        return accountDao.findByUserNameOrEmail(userNameOrEmail);
    }

    @Override
    public void createAccount(SignUp signUp) {
        Optional.of(accountDao.checkUserExistence(signUp.getUserName()))
            .ifPresent(aLong -> { throw new BusinessException(Errors.USER_ALREADY_EXISTS.name()); });
        Optional.of(accountDao.checkUserExistence(signUp.getEmail()))
            .ifPresent(aLong -> { throw new BusinessException(Errors.USER_ALREADY_EXISTS.name()); });

        accountDao.insertAccount(AccountWithPassword.builder()
            .withAccount(Account.builder()
                .withId(IdentifierHelper.generateLongId())
                .withUserName(signUp.getUserName())
                .withEmail(signUp.getEmail())
                .withStatus(AccountStatus.NEW)
                .withCreationDate(LocalDate.now())
                .withLanguage(signUp.getLanguage())
                .build())
            .withPassword(MD5Helper.generateMD5hashWithSalt(signUp.getPassword())).build());
    }

    @Override
    public void changePassword(ChangePassword changePassword) {

    }
}
