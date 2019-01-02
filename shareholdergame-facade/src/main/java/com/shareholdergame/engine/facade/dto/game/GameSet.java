package com.shareholdergame.engine.facade.dto.game;

import java.time.LocalDateTime;
import java.util.Set;

public class GameSet {

    private Long id;

    private LocalDateTime createdTime;

    private LocalDateTime startedTime;

    private LocalDateTime finishedTime;

    private GameStatus status;

    private boolean published;

    private Set<GamePlayer> players;

    private Set<PlayerResult> result;
}
