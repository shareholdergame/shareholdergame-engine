package com.shareholdergame.engine.facade.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Date: 10/08/2018
 *
 * @author Aliaksandr Savin
 */
public class Achievements implements Serializable {

    private Long totalPlayed;

    private Long win;

    private Long firstTurnWin;

    private Long lastTurnWin;

    private Long positiveDraw;

    private Long negativeDraw;

    private Long loss;

    private Long bankrupt;

    private Double winPercent;

    private Long maxTotalSum;

    private Long maxWonSum;

    private Long totalWonSum;

    @JsonCreator
    public Achievements(@JsonProperty("totalPlayed") Long totalPlayed,
                        @JsonProperty("win") Long win,
                        @JsonProperty("firstTurnWin") Long firstTurnWin,
                        @JsonProperty("lastTurnWin") Long lastTurnWin,
                        @JsonProperty("positiveDraw") Long positiveDraw,
                        @JsonProperty("negativeDraw") Long negativeDraw,
                        @JsonProperty("loss") Long loss,
                        @JsonProperty("bankrupt") Long bankrupt,
                        @JsonProperty("winPercent") Double winPercent,
                        @JsonProperty("maxTotalSum") Long maxTotalSum,
                        @JsonProperty("maxWonSum") Long maxWonSum,
                        @JsonProperty("totalWonSum") Long totalWonSum) {
        this.totalPlayed = totalPlayed;
        this.win = win;
        this.firstTurnWin = firstTurnWin;
        this.lastTurnWin = lastTurnWin;
        this.positiveDraw = positiveDraw;
        this.negativeDraw = negativeDraw;
        this.loss = loss;
        this.bankrupt = bankrupt;
        this.winPercent = winPercent;
        this.maxTotalSum = maxTotalSum;
        this.maxWonSum = maxWonSum;
        this.totalWonSum = totalWonSum;
    }

    public Long getTotalPlayed() {
        return totalPlayed;
    }

    public Long getWin() {
        return win;
    }

    public Long getFirstTurnWin() {
        return firstTurnWin;
    }

    public Long getLastTurnWin() {
        return lastTurnWin;
    }

    public Long getPositiveDraw() {
        return positiveDraw;
    }

    public Long getNegativeDraw() {
        return negativeDraw;
    }

    public Long getLoss() {
        return loss;
    }

    public Long getBankrupt() {
        return bankrupt;
    }

    public Double getWinPercent() {
        return winPercent;
    }

    public Long getMaxTotalSum() {
        return maxTotalSum;
    }

    public Long getMaxWonSum() {
        return maxWonSum;
    }

    public Long getTotalWonSum() {
        return totalWonSum;
    }
}
