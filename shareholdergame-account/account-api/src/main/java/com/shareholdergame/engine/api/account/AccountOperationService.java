package com.shareholdergame.engine.api.account;

import com.shareholdergame.engine.account.model.AccountOperation;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public interface AccountOperationService {

    void markVerified(Long operationId);

    AccountOperation getOperation(Long gamerId, String verificationCode);
}
