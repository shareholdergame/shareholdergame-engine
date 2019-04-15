package com.shareholdergame.engine.facade.client;

import com.shareholdergame.engine.api.account.AccountService;
import com.shareholdergame.engine.api.account.PasswordUpdate;
import com.shareholdergame.engine.api.account.NewAccount;
import com.shareholdergame.engine.account.model.AccountWithPassword;
import com.shareholdergame.engine.common.http.ResponseWrapper;
import io.micronaut.http.client.annotation.Client;

@Client(value = "${service.account.url}/account", errorType = ResponseWrapper.ErrorResponse.class)
public interface AccountClient extends AccountService {

    @Override
    boolean checkUserExistence(String userNameOrEmail);

    @Override
    AccountWithPassword findUserByNameOrEmail(String userNameOrEmail);

    @Override
    void createAccount(NewAccount newAccount);

    @Override
    void changePassword(Long gamerId, PasswordUpdate passwordUpdate);
}
