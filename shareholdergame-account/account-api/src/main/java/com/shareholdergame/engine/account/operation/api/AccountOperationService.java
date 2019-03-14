package com.shareholdergame.engine.account.operation.api;

import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;

@Validated
public interface AccountOperationService {

    @Post("/verify/{gamerId}/{verificationCode}")
    void verifyAccount(Long gamerId, String verificationCode);
}
