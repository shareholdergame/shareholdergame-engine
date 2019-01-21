package com.shareholdergame.engine.facade.dto.game;

import java.time.LocalDateTime;
import java.util.Set;

public class ReportTurn {

    public short round;

    public short turn;

    public LocalDateTime finishedTime;

    public Set<ReportStep> steps;
}
