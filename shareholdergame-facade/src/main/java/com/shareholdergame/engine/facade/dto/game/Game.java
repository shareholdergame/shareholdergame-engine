package com.shareholdergame.engine.facade.dto.game;

import java.util.Set;

public class Game {

    private Long id;

    private GameLetter letter;

    private Set<TurnOrderResult> result;

    private GameReport report;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GameLetter getLetter() {
        return letter;
    }

    public void setLetter(GameLetter letter) {
        this.letter = letter;
    }

    public Set<TurnOrderResult> getResult() {
        return result;
    }

    public void setResult(Set<TurnOrderResult> result) {
        this.result = result;
    }

    public GameReport getReport() {
        return report;
    }

    public void setReport(GameReport report) {
        this.report = report;
    }
}
