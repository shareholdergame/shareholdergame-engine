package com.shareholdergame.engine.account.dao.mapper;

import com.shareholdergame.engine.account.model.Profile;

public interface ProfileMapper {

    Profile findById(Long gamerId);

    void insertProfile(Profile profile);
}
