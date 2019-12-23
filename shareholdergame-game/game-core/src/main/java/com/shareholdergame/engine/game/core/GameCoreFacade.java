package com.shareholdergame.engine.game.core;

import com.shareholdergame.engine.game.core.configuration.GameConfiguration;
import com.shareholdergame.engine.game.core.configuration.GameConfigurationManager;

public class GameCoreFacade {

    private GameConfigurationManager configurationManager;

    GameCoreFacade(GameConfigurationManager configurationManager) {
        this.configurationManager = configurationManager;
    }

    public GameConfiguration getDefaultConfiguration() {
        return configurationManager.getDefault();
    }

    public void startGameSet(Long gameSetId, String gameConfigurationName, CardOption cardOption, String... players) {

    }

    public void loadGameSet(Long gameSetId, GameReport report) {

    }

    public void doTurn(Long gameSetId, String gameLetter, Turn turn) {

    }

    public GameReport gameReport(Long gameSetId) {
        return new GameReport();
    }
}
