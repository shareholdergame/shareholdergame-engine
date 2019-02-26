package com.shareholdergame.engine.account.listener;

import com.shareholdergame.engine.account.model.GamerAccount;
import com.shareholdergame.engine.common.event.BusinessEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.scheduling.annotation.Async;

import javax.inject.Singleton;

@Singleton
public class AccountCreatedListener {

    @EventListener
    @Async
    public void onAccountCreated(BusinessEvent<GamerAccount> event) {

    }
}
