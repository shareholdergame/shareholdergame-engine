package com.shareholdergame.engine.api.account;

import javax.validation.constraints.NotBlank;

import com.shareholdergame.engine.account.model.AccountWithPassword;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.validation.Validated;

@Validated
public interface AccountService {

    @Get("/exists/{userNameOrEmail}")
    boolean checkUserExistence(@NotBlank String userNameOrEmail);

    @Get("/{userNameOrEmail}")
    AccountWithPassword findUserByNameOrEmail(@NotBlank String userNameOrEmail);

    @Put("/create")
    void createAccount(@Body NewAccount newAccount);

    @Post("/update/{gamerId}/password")
    void changePassword(Long gamerId, @Body UpdatePassword updatePassword);

    @Post("/update/{gamerId}/password/reset")
    void resetPassword(Long gamerId);
}
