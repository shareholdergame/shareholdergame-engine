package com.shareholdergame.engine.account.api;

import javax.validation.constraints.NotBlank;

import com.shareholdergame.engine.account.model.AccountWithPassword;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.validation.Validated;

@Validated
public interface AccountOperations {

    @Get("/exists/{userNameOrEmail}")
    boolean checkUserExistence(@NotBlank String userNameOrEmail);

    @Get("/{userNameOrEmail}")
    AccountWithPassword findUserByNameOrEmail(@NotBlank String userNameOrEmail);

    @Put(value = "/create", consumes = MediaType.APPLICATION_FORM_URLENCODED)
    void createAccount(@QueryValue @NotBlank String userName,
                       @QueryValue @NotBlank String email,
                       @QueryValue @NotBlank String password);
}
