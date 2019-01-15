package com.shareholdergame.engine.facade.dto.game;

import java.util.Set;

public class GameReport {

    private Set<ReportPlayer> players;

    private Set<ReportRound> rounds;

    public Set<ReportPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(Set<ReportPlayer> players) {
        this.players = players;
    }

    public Set<ReportRound> getRounds() {
        return rounds;
    }

    public void setRounds(Set<ReportRound> rounds) {
        this.rounds = rounds;
    }
}
