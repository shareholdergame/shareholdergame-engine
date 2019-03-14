package com.shareholdergame.engine.facade.client;

import com.shareholdergame.engine.account.api.AccountService;
import com.shareholdergame.engine.account.api.ChangePassword;
import com.shareholdergame.engine.account.api.SignUp;
import com.shareholdergame.engine.account.model.AccountWithPassword;
import io.micronaut.http.client.annotation.Client;

@Client("${service.account.url}/account")
public interface AccountClient extends AccountService {

    @Override
    boolean checkUserExistence(String userNameOrEmail);

    @Override
    AccountWithPassword findUserByNameOrEmail(String userNameOrEmail);

    @Override
    void createAccount(SignUp signUp);

    @Override
    void changePassword(Long gamerId, ChangePassword changePassword);
}
