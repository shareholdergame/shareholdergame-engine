package com.shareholdergame.engine.game.core;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

@Singleton
public class GameCoreWrapper {

    @PostConstruct
    public void init() {
        GameCore.initialize();
    }

    public GameCoreFacade facade() {
        return GameCore.facade();
    }
}
