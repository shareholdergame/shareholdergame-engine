package com.shareholdergame.engine.account.listener;

import com.shareholdergame.engine.account.model.GamerAccount;
import com.shareholdergame.engine.account.model.UserLocation;
import com.shareholdergame.engine.account.support.CountryDetector;
import com.shareholdergame.engine.common.event.BusinessEvent;
import com.shareholdergame.engine.common.exception.ApplicationException;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.scheduling.annotation.Async;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Singleton
public class AccountCreatedListener {

    @Inject
    private CountryDetector countryDetector;

    @EventListener
    @Async
    public void onAccountCreated(BusinessEvent<GamerAccount> event) {
        GamerAccount gamerAccount = event.getPayload();
        String ipAddresss = gamerAccount.getRegisteredFromIp();
        UserLocation userLocation = countryDetector.detect(ipAddresss);
    }
}
