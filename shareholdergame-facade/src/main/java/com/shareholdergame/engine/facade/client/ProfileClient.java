package com.shareholdergame.engine.facade.client;

import com.shareholdergame.engine.account.model.Profile;
import com.shareholdergame.engine.profile.api.ProfileOperations;
import io.micronaut.http.client.annotation.Client;

@Client("${service.account.url}/account")
public interface ProfileClient extends ProfileOperations {

    @Override
    Profile getProfile(String userNameOrEmail);
}
