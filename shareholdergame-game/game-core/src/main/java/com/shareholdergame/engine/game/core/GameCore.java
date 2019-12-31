package com.shareholdergame.engine.game.core;

import com.shareholdergame.engine.game.core.configuration.GameConfigurationManager;
import com.shareholdergame.engine.game.core.facade.GameCoreFacade;

public final class GameCore {

    private static GameCore instance;

    private GameConfigurationManager configurationManager;

    private GameCoreFacade facade;

    private GameCore() {
    }

    public static void initialize() {
        if (null == instance) {
            instance = new GameCore();
        }
        instance.configurationManager = new GameConfigurationManager();
        instance.facade = new GameCoreFacade(instance.configurationManager);
    }

    public static GameCoreFacade facade() {
        return instance.facade;
    }
}
