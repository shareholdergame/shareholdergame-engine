package com.shareholdergame.engine.game.core;

public class GameCoreFacade {

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
