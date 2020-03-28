package com.shareholdergame.engine.game.service;

import com.shareholdergame.engine.api.game.GameService;
import com.shareholdergame.engine.common.exception.ApplicationException;
import com.shareholdergame.engine.game.core.CardOption;
import com.shareholdergame.engine.game.core.GameCoreWrapper;
import com.shareholdergame.engine.game.core.configuration.GameConfiguration;
import com.shareholdergame.engine.game.core.exception.ConfigurationReadingException;
import org.apache.commons.lang3.ArrayUtils;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Map;

@Singleton
public class GameServiceImpl implements GameService {

    @Inject
    private GameCoreWrapper gameCoreWrapper;

    @Override
    public Long startGame(Map<String, Object> gameOptions, String initiator, String... players) {
        GameConfiguration defaultConfiguration = gameCoreWrapper.facade().getDefaultConfiguration();
        long gameSetId = 1L;
        gameCoreWrapper.facade().startGameSet(gameSetId, defaultConfiguration, CardOption.of(4, 6),
                ArrayUtils.add(players, initiator));
        return gameSetId;
    }
}
