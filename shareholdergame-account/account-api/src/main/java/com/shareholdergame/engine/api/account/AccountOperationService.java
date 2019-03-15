package com.shareholdergame.engine.api.account;

import com.shareholdergame.engine.account.model.AccountOperation;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Validated
public interface AccountOperationService {

    @Post("/{operationId}/verify")
    void markVerified(@NotNull Long operationId);

    @Get("/{gamerId}/{verificationCode}")
    AccountOperation getOperation(@NotNull Long gamerId, @NotBlank String verificationCode);
}
