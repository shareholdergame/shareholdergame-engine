package com.shareholdergame.engine.facade.dto.game;

import java.time.LocalDateTime;
import java.util.Set;

public class GameSet {

    public Long id;

    public Set<GameOption> options;

    public LocalDateTime createdTime;

    public LocalDateTime startedTime;

    public LocalDateTime finishedTime;

    public GameStatus status;

    public boolean published;

    public Set<GamePlayer> players;

    public Set<PlayerResult> result;
}
