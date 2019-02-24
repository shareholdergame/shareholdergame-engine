package com.shareholdergame.engine.facade.dto.game;

import io.swagger.v3.oas.annotations.Parameter;

public class PlayerResult {

    @Parameter
    public Long playerId;

    @Parameter
    public boolean winner;

    @Parameter
    public boolean bankrupt;

    @Parameter
    public short totalPoints;

    @Parameter
    public long totalFunds;

    @Parameter
    public long fundsDifference;
}
