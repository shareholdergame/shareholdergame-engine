package com.shareholdergame.engine.account.event;

import com.shareholdergame.engine.account.model.UserSessionLogRecord;
import com.shareholdergame.engine.common.event.BusinessEvent;

public class UserLoggedInEvent extends BusinessEvent<AccountServiceEventType, UserSessionLogRecord> {

    private UserLoggedInEvent(UserSessionLogRecord payload) {
        super(AccountServiceEventType.USER_LOGGED_IN, payload);
    }

    public static UserLoggedInEvent of(UserSessionLogRecord logRecord) {
        return new UserLoggedInEvent(logRecord);
    }
}
