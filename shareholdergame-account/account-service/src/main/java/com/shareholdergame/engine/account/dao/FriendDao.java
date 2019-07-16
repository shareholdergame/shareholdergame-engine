package com.shareholdergame.engine.account.dao;

import com.shareholdergame.engine.account.dao.mapper.FriendMapper;
import com.shareholdergame.engine.account.model.Friend;
import com.shareholdergame.engine.common.sql.BaseDao;
import org.apache.ibatis.session.SqlSessionManager;

public class FriendDao extends BaseDao<FriendMapper> implements FriendMapper {

    protected FriendDao(SqlSessionManager sqlSessionManager) {
        super(sqlSessionManager);
    }

    @Override
    public void insertFriend(Friend friend) {
        getMapper().insertFriend(friend);
    }
}
