package com.shareholdergame.engine.account.dao;

import com.shareholdergame.engine.account.dao.mapper.ProfileMapper;
import com.shareholdergame.engine.account.model.Profile;
import org.apache.ibatis.session.SqlSessionManager;

import javax.inject.Singleton;

@Singleton
public class ProfileDao implements ProfileMapper {

    private final SqlSessionManager sqlSessionManager;

    public ProfileDao(SqlSessionManager sqlSessionManager) {
        this.sqlSessionManager = sqlSessionManager;
    }

    @Override
    public Profile findById(Long gamerId) {
        return getMapper().findById(gamerId);
    }

    @Override
    public void insertProfile(Profile profile) {
        getMapper().insertProfile(profile);
    }

    @Override
    public void updateProfile(Profile profile) {
        getMapper().updateProfile(profile);
    }

    private ProfileMapper getMapper() {
        return sqlSessionManager.getMapper(ProfileMapper.class);
    }
}
