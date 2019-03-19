package com.shareholdergame.engine.account.event.listener;

import com.shareholdergame.engine.account.dao.ProfileDao;
import com.shareholdergame.engine.account.event.AccountCreatedEvent;
import com.shareholdergame.engine.account.model.GamerAccount;
import com.shareholdergame.engine.account.model.Profile;
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

    @Inject
    private ProfileDao profileDao;

    @EventListener
    @Async
    public void onAccountCreated(AccountCreatedEvent event) {
        GamerAccount gamerAccount = event.getPayload();
        String ipAddresss = gamerAccount.getRegisteredFromIp();
        UserLocation userLocation = countryDetector.detect(ipAddresss);

        Profile profile = profileDao.findById(gamerAccount.getId());
        Profile.ProfileBuilder profileBuilder = Profile.builder();
        if (null == profile) {
            profileBuilder.gamerId(gamerAccount.getId());
            profileBuilder.country(userLocation.getCountry());
            profileBuilder.detectedCountry(userLocation.getCountry());
            profileBuilder.city(userLocation.getCity());
            profileBuilder.detectedCity(userLocation.getCity());
            profileBuilder.stateProvince(userLocation.getProvince());
            profileBuilder.detectedStateProvince(userLocation.getProvince());

            profileDao.insertProfile(profileBuilder.build());
        } else {
            profileBuilder.profile(profile);
            profileBuilder.detectedCountry(userLocation.getCountry());
            profileBuilder.detectedCity(userLocation.getCity());
            profileBuilder.detectedStateProvince(userLocation.getProvince());

            profileDao.updateProfile(profileBuilder.build());
        }
    }
}
