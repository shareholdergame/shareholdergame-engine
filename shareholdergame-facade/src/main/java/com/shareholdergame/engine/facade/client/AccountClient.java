package com.shareholdergame.engine.facade.client;

import com.shareholdergame.engine.account.api.AccountOperations;
import com.shareholdergame.engine.account.model.AccountWithPassword;
import io.micronaut.http.client.annotation.Client;

@Client("${service.account.url}/service/account")
public interface AccountClient extends AccountOperations {

    @Override
    boolean checkUserExistence(String userNameOrEmail);

    @Override
    AccountWithPassword findUserByNameOrEmail(String userNameOrEmail);

    @Override
    void createAccount(String userName, String email, String password);
}
