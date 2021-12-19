package com.shareholdergame.engine.game.core;

import com.shareholdergame.engine.game.core.configuration.GameConfigurationManager;
import com.shareholdergame.engine.game.core.facade.GameCoreFacade;

public final class GameCore {

    private GameCoreFacade facade;

    private GameCore(GameCoreFacade facade) {
        this.facade = facade;
    }

    public static GameCoreFacade facade() {
        return GameCoreHolder.instance.facade;
    }

    private static class GameCoreHolder {
        static final GameCore instance = new GameCore(new GameCoreFacade(new GameConfigurationManager()));
    }
}
