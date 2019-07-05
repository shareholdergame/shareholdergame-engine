package com.shareholdergame.engine.api.account;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.shareholdergame.engine.account.model.AccountWithPassword;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.validation.Validated;

public interface AccountService {

    boolean checkUserExistence(String userNameOrEmail);

    AccountWithPassword findUserByNameOrEmail(String userNameOrEmail);

    void createAccount(NewAccount newAccount);

    void changePassword(Long gamerId, PasswordUpdate passwordUpdate);

    void resetPassword(Long gamerId);

    void verify(Long gamerId, String verificationCode);
}
