package com.shareholdergame.engine.facade.dto.game;

import java.util.Set;

public class Game {

    public Long id;

    public GameLetter letter;

    public Set<TurnOrderResult> result;

    public GameReport report;
}
