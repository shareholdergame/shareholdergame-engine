package com.shareholdergame.engine.facade.dto.game;

import java.time.LocalDateTime;
import java.util.Set;

public class ReportRound {

    public short round;

    public Set<ReportTurn> turns;

    public LocalDateTime finishedTime;
}
