package com.shareholdergame.engine.profile.api;

import com.shareholdergame.engine.account.model.Profile;
import io.micronaut.http.annotation.Get;
import io.micronaut.validation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
public interface ProfileOperations {

    @Get("/{gamerId}")
    Profile getProfile(@NotBlank Long gamerId);
}
