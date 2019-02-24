package com.shareholdergame.engine.account.service;

import com.shareholdergame.engine.account.api.AccountOperations;
import com.shareholdergame.engine.account.api.ChangePassword;
import com.shareholdergame.engine.account.api.SignUp;
import com.shareholdergame.engine.account.dao.AccountDao;
import com.shareholdergame.engine.account.dao.Transactional;
import com.shareholdergame.engine.account.model.AccountStatus;
import com.shareholdergame.engine.account.model.AccountWithPassword;
import com.shareholdergame.engine.account.model.GamerAccount;
import com.shareholdergame.engine.common.util.IdentifierHelper;
import com.shareholdergame.engine.common.util.MD5Helper;
import io.micronaut.http.annotation.Controller;

import javax.inject.Inject;
import java.time.LocalDate;

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
    @Transactional
    public void createAccount(SignUp signUp) {
        accountDao.insertAccount(AccountWithPassword.builder()
                .account(GamerAccount.builder()
                        .withId(IdentifierHelper.generateLongId())
                        .withUserName(signUp.getUserName())
                        .withEmail(signUp.getEmail())
                        .withStatus(AccountStatus.NEW)
                        .withCreationDate(LocalDate.now())
                        .withLanguage(signUp.getLanguage())
                        .build())
                .password(MD5Helper.generateMD5hashWithSalt(signUp.getPassword())).build());
    }

    @Override
    public void changePassword(ChangePassword changePassword) {

    }
}
