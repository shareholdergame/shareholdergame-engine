package com.shareholdergame.engine.api.profile;

import com.shareholdergame.engine.account.model.Profile;
import io.micronaut.http.annotation.Get;
import io.micronaut.validation.Validated;

import javax.validation.constraints.NotBlank;

public interface ProfileService {

    Profile getProfile(Long gamerId);

    void createFriendRequest(Long gamerId, Long friendId);
}
