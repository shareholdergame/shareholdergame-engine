package com.shareholdergame.engine.account.service;

import com.shareholdergame.engine.account.model.Profile;
import com.shareholdergame.engine.profile.api.ProfileOperations;
import io.micronaut.http.annotation.Controller;

import javax.validation.constraints.NotBlank;

@Controller("/profile")
public class ProfileService implements ProfileOperations {

    @Override
    public Profile getProfile(@NotBlank String userNameOrEmail) {
        return null;
    }
}
