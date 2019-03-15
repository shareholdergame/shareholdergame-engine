package com.shareholdergame.engine.facade.client;

import com.shareholdergame.engine.api.account.AccountService;
import com.shareholdergame.engine.api.account.ChangePassword;
import com.shareholdergame.engine.api.account.SignUp;
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
