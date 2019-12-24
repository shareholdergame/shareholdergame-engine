package com.shareholdergame.engine.api.game;

public interface GameService {

    Long startGame(String initiator, String... players);
}
