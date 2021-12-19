package com.shareholdergame.engine.account.event.listener;

import com.shareholdergame.engine.account.dao.UserSessionLogDao;
import com.shareholdergame.engine.account.event.UserLoggedInEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.scheduling.annotation.Async;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class UserSessionListener {

    @Inject
    private UserSessionLogDao userSessionLogDao;

    @EventListener
    @Async
    public void onUserLoggedIn(UserLoggedInEvent event) {
        userSessionLogDao.insertLogRecord(event.getPayload());
    }
}
