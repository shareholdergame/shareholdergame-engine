package com.shareholdergame.engine.facade.client;

import com.shareholdergame.engine.account.operation.api.AccountOperationService;
import io.micronaut.http.client.annotation.Client;

@Client("${service.account.url}/account/operation")
public interface AccountOperationClient extends AccountOperationService {

    @Override
    void verifyAccount(Long gamerId, String verificationCode);
}
