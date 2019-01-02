package com.shareholdergame.engine.account.service;

import com.shareholdergame.engine.account.api.AccountOperations;
import com.shareholdergame.engine.account.model.AccountWithPassword;
import com.shareholdergame.engine.account.model.mock.MockDataProvider;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.exceptions.HttpStatusException;

@Controller("/service/account")
public class AccountService implements AccountOperations {

    @Override
    public boolean checkUserExistence(String userNameOrEmail) {
        AccountWithPassword userAccount = findByUserNameOrEmail(userNameOrEmail);
        return userAccount != null;
    }

    @Override
    public AccountWithPassword findUserByNameOrEmail(String userNameOrEmail) {
        AccountWithPassword userAccount = findByUserNameOrEmail(userNameOrEmail);
        if (userAccount == null) {
            throw new HttpStatusException(HttpStatus.NOT_FOUND, userNameOrEmail);
        }
        return userAccount;
    }

    private AccountWithPassword findByUserNameOrEmail(String userNameOrEmail) {
        return MockDataProvider.getAccountWithPasswordList().stream()
                .filter(accountWithPassword -> accountWithPassword.getAccount().getEmail().equalsIgnoreCase(userNameOrEmail)
                        || accountWithPassword.getAccount().getUserName().equalsIgnoreCase(userNameOrEmail)).findFirst().orElse(null);
    }
}
