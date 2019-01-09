package com.shareholdergame.engine.account.service;

import com.shareholdergame.engine.account.api.AccountOperations;
import com.shareholdergame.engine.account.dao.AccountDao;
import com.shareholdergame.engine.account.model.AccountWithPassword;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.exceptions.HttpStatusException;

import javax.inject.Inject;

@Controller("/service/account")
public class AccountService implements AccountOperations {

    @Inject
    private AccountDao accountDao;

    @Override
    public boolean checkUserExistence(String userNameOrEmail) {
        AccountWithPassword userAccount = accountDao.findByUserNameOrEmail(userNameOrEmail);
        return userAccount != null;
    }

    @Override
    public AccountWithPassword findUserByNameOrEmail(String userNameOrEmail) {
        AccountWithPassword userAccount = accountDao.findByUserNameOrEmail(userNameOrEmail);
        if (userAccount == null) {
            throw new HttpStatusException(HttpStatus.NOT_FOUND, userNameOrEmail);
        }
        return userAccount;
    }

    /*private AccountWithPassword findByUserNameOrEmail(String userNameOrEmail) {
        return MockDataProvider.getAccountWithPasswordList().stream()
                .filter(accountWithPassword -> accountWithPassword.getAccount().getEmail().equalsIgnoreCase(userNameOrEmail)
                        || accountWithPassword.getAccount().getUserName().equalsIgnoreCase(userNameOrEmail)).findFirst().orElse(null);
    }*/
}
