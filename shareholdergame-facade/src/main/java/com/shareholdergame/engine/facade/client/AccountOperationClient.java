package com.shareholdergame.engine.facade.client;

import com.shareholdergame.engine.account.model.AccountOperation;
import com.shareholdergame.engine.api.account.AccountOperationService;
import io.micronaut.http.client.annotation.Client;

@Client("${service.account.url}/account/operation")
public interface AccountOperationClient extends AccountOperationService {

    @Override
    void markVerified(Long operationId);

    @Override
    AccountOperation getOperation(Long gamerId, String verificationCode);
}
