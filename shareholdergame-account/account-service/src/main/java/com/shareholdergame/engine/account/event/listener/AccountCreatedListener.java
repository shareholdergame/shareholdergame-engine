package com.shareholdergame.engine.account.event.listener;

import com.shareholdergame.engine.account.event.AccountCreatedEvent;
import com.shareholdergame.engine.account.model.GamerAccount;
import com.shareholdergame.engine.account.model.UserLocation;
import com.shareholdergame.engine.account.support.CountryDetector;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.scheduling.annotation.Async;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AccountCreatedListener {

    @Inject
    private CountryDetector countryDetector;

    @EventListener
    @Async
    public void onAccountCreated(AccountCreatedEvent event) {
        GamerAccount gamerAccount = event.getPayload();
        String ipAddresss = gamerAccount.getRegisteredFromIp();
        UserLocation userLocation = countryDetector.detect(ipAddresss);
    }
}
