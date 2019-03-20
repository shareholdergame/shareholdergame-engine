package com.shareholdergame.engine.facade.client;

import com.shareholdergame.engine.api.account.AccountService;
import com.shareholdergame.engine.api.account.UpdatePassword;
import com.shareholdergame.engine.api.account.NewAccount;
import com.shareholdergame.engine.account.model.AccountWithPassword;
import io.micronaut.http.client.annotation.Client;

@Client("${service.account.url}/account")
public interface AccountClient extends AccountService {

    @Override
    boolean checkUserExistence(String userNameOrEmail);

    @Override
    AccountWithPassword findUserByNameOrEmail(String userNameOrEmail);

    @Override
    void createAccount(NewAccount newAccount);

    @Override
    void changePassword(Long gamerId, UpdatePassword updatePassword);
}
