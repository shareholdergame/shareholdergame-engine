package com.shareholdergame.engine.account.dao;

import com.shareholdergame.engine.account.dao.mapper.UserSessionLogMapper;
import com.shareholdergame.engine.account.model.UserSessionLogRecord;
import com.shareholdergame.engine.common.sql.BaseDao;
import org.apache.ibatis.session.SqlSessionManager;

public class UserSessionLogDao extends BaseDao<UserSessionLogMapper> implements UserSessionLogMapper {

    protected UserSessionLogDao(SqlSessionManager sqlSessionManager) {
        super(sqlSessionManager);
    }

    @Override
    public void insertLogRecord(UserSessionLogRecord logRecord) {
        getMapper().insertLogRecord(logRecord);
    }
}
