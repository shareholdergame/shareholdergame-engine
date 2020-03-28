package com.shareholdergame.engine.game.core;

import com.shareholdergame.engine.common.exception.ApplicationException;
import com.shareholdergame.engine.game.core.configuration.GameConfiguration;
import com.shareholdergame.engine.game.core.exception.ConfigurationReadingException;
import com.shareholdergame.engine.game.core.facade.GameCoreFacade;
import com.shareholdergame.engine.game.core.turn.Turn;

import javax.inject.Singleton;

@Singleton
public class GameCoreWrapper {

    public GameCoreFacadeWrapper facade() {
        return new GameCoreFacadeWrapper(GameCore.facade());
    }

    public static class GameCoreFacadeWrapper {

        private GameCoreFacade gameCoreFacade;

        public GameCoreFacadeWrapper(GameCoreFacade gameCoreFacade) {
            this.gameCoreFacade = gameCoreFacade;
        }

        public GameConfiguration getDefaultConfiguration() {
            try {
                return gameCoreFacade.getDefaultConfiguration();
            } catch (ConfigurationReadingException e) {
                throw new ApplicationException(e);
            }
        }

        public void startGameSet(Long gameSetId, GameConfiguration gameConfiguration, CardOption cardOption, String... players) {
            gameCoreFacade.startGameSet(gameSetId, gameConfiguration, cardOption, players);
        }

        public void loadGameSet(Long gameSetId, GameReport report) {
            gameCoreFacade.loadGameSet(gameSetId, report);
        }

        public void doTurn(Long gameSetId, String gameLetter, Turn turn) {
            gameCoreFacade.doTurn(gameSetId, gameLetter, turn);
        }

        public GameReport gameReport(Long gameSetId) {
            return gameCoreFacade.gameReport(gameSetId);
        }
    }
}
