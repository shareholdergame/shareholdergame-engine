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

        if (null == profile) {
            Profile.ProfileBuilder profileBuilder = Profile.builder()
                    .gamerId(gamerAccount.getId())
                    .country(userLocation.getCountry())
                    .detectedCountry(userLocation.getCountry())
                    .city(userLocation.getCity())
                    .detectedCity(userLocation.getCity())
                    .stateProvince(userLocation.getProvince())
                    .detectedStateProvince(userLocation.getProvince());

            profileDao.insertProfile(profileBuilder.build());
        } else {
            profile.setDetectedCountry(userLocation.getCountry());
            profile.setDetectedCity(userLocation.getCity());
            profile.setDetectedStateProvince(userLocation.getProvince());

            profileDao.updateProfile(profile);
        }
    }
}
