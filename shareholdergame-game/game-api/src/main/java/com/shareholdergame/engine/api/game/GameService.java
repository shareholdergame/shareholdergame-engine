package com.shareholdergame.engine.api.game;

import java.util.Map;

public interface GameService {

    Long startGame(Map<String, Object> gameOptions, String initiator, String... players);
}
