package com.shareholdergame.engine.facade.dto.game;

public class PlayerResult {

    private Long playerId;

    private boolean winner;

    private boolean bankrupt;

    private short totalPoints;

    private long totalFunds;

    private long fundsDifference;

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public boolean isBankrupt() {
        return bankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        this.bankrupt = bankrupt;
    }

    public short getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(short totalPoints) {
        this.totalPoints = totalPoints;
    }

    public long getTotalFunds() {
        return totalFunds;
    }

    public void setTotalFunds(long totalFunds) {
        this.totalFunds = totalFunds;
    }

    public long getFundsDifference() {
        return fundsDifference;
    }

    public void setFundsDifference(long fundsDifference) {
        this.fundsDifference = fundsDifference;
    }
}
