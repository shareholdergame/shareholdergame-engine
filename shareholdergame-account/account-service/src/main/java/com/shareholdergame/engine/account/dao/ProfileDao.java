package com.shareholdergame.engine.account.dao;

import com.shareholdergame.engine.account.dao.mapper.ProfileMapper;
import com.shareholdergame.engine.account.model.Profile;
import com.shareholdergame.engine.common.sql.BaseDao;
import jakarta.inject.Singleton;
import org.apache.ibatis.session.SqlSessionManager;

@Singleton
public class ProfileDao extends BaseDao<ProfileMapper> implements ProfileMapper {

    public ProfileDao(SqlSessionManager sqlSessionManager) {
        super(sqlSessionManager);
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
}
