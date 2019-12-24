package com.shareholdergame.engine.game.service;

import com.shareholdergame.engine.api.game.GameService;
import com.shareholdergame.engine.game.core.GameCoreWrapper;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GameServiceImpl implements GameService {

    @Inject
    private GameCoreWrapper gameCoreWrapper;

    @Override
    public Long startGame(String initiator, String... players) {
        return null;
    }
}
