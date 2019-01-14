package com.shareholdergame.engine.account.api;

import javax.validation.constraints.NotBlank;

import com.shareholdergame.engine.account.model.AccountWithPassword;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Put;
import io.micronaut.validation.Validated;

@Validated
public interface AccountOperations {

    @Get("/exists/{userNameOrEmail}")
    boolean checkUserExistence(@NotBlank String userNameOrEmail);

    @Get("/{userNameOrEmail}")
    AccountWithPassword findUserByNameOrEmail(@NotBlank String userNameOrEmail);

    @Put(value = "/create")
    void createAccount(@Body SignUpData signUpData);
}
