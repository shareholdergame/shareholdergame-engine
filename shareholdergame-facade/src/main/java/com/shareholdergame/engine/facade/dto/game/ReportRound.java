package com.shareholdergame.engine.facade.dto.game;

import java.time.LocalDateTime;
import java.util.Set;

public class ReportRound {

    private short round;

    private Set<ReportTurn> turns;

    private LocalDateTime finishedTime;

    public short getRound() {
        return round;
    }

    public void setRound(short round) {
        this.round = round;
    }

    public Set<ReportTurn> getTurns() {
        return turns;
    }

    public void setTurns(Set<ReportTurn> turns) {
        this.turns = turns;
    }

    public LocalDateTime getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(LocalDateTime finishedTime) {
        this.finishedTime = finishedTime;
    }
}
