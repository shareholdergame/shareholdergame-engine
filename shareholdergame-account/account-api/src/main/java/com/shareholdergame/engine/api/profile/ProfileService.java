package com.shareholdergame.engine.api.profile;

import com.shareholdergame.engine.account.model.Profile;
import io.micronaut.http.annotation.Get;
import io.micronaut.validation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
public interface ProfileService {

    @Get("/{gamerId}")
    Profile getProfile(@NotBlank Long gamerId);
}
