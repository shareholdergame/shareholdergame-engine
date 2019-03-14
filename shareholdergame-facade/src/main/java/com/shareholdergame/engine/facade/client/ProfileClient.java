package com.shareholdergame.engine.facade.client;

import com.shareholdergame.engine.account.model.Profile;
import com.shareholdergame.engine.profile.api.ProfileService;
import io.micronaut.http.client.annotation.Client;

@Client("${service.account.url}/profile")
public interface ProfileClient extends ProfileService {

    @Override
    Profile getProfile(Long gamerId);
}
