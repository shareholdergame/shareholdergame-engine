package com.shareholdergame.engine.account.dao.mapper;

import com.shareholdergame.engine.account.model.UserSessionLogRecord;

public interface UserSessionLogMapper {

    void insertLogRecord(UserSessionLogRecord logRecord);
}
