package com.shareholdergame.engine.facade.dto.game;

import java.time.LocalDateTime;
import java.util.Set;

public class ReportTurn {

    private short round;

    private short turn;

    private LocalDateTime finishedTime;

    private Set<ReportStep> steps;

    public short getRound() {
        return round;
    }

    public void setRound(short round) {
        this.round = round;
    }

    public short getTurn() {
        return turn;
    }

    public void setTurn(short turn) {
        this.turn = turn;
    }

    public LocalDateTime getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(LocalDateTime finishedTime) {
        this.finishedTime = finishedTime;
    }

    public Set<ReportStep> getSteps() {
        return steps;
    }

    public void setSteps(Set<ReportStep> steps) {
        this.steps = steps;
    }
}
