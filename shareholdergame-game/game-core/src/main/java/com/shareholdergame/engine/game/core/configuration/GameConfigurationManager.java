package com.shareholdergame.engine.game.core.configuration;

import com.shareholdergame.engine.game.core.exception.ConfigurationReadingException;

public class GameConfigurationManager {

    private GameConfigurationReader reader = new GameConfigurationReader();

    private GameConfiguration defaultConfiguration;

    public GameConfiguration getDefault() throws ConfigurationReadingException {
        if (null == defaultConfiguration) {
            defaultConfiguration = reader.readConfiguration();
        }
        return defaultConfiguration;
    }
}
