package com.shareholdergame.engine.game.core.configuration;

public class GameConfigurationManager {

    private GameConfigurationReader reader = new GameConfigurationReader();

    private GameConfiguration defaultConfiguration;

    public GameConfiguration getDefault() {
        if (null == defaultConfiguration) {
            defaultConfiguration = reader.readConfiguration();
        }
        return defaultConfiguration;
    }
}
