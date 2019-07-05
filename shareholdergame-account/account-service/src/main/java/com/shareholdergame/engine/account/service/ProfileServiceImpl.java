package com.shareholdergame.engine.account.service;

import com.shareholdergame.engine.account.dao.ProfileDao;
import com.shareholdergame.engine.account.model.Profile;
import com.shareholdergame.engine.api.profile.ProfileService;
import io.micronaut.http.annotation.Controller;

import javax.inject.Inject;
import javax.validation.constraints.NotBlank;

@Controller("/profile")
public class ProfileServiceImpl implements ProfileService {

    @Inject
    private ProfileDao profileDao;

    @Override
    public Profile getProfile(@NotBlank Long gamerId) {
        return profileDao.findById(gamerId);
    }
}
