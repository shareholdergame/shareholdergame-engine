package com.shareholdergame.engine.facade.dto.game;

import java.util.Set;

public class ReportStep {

    public StepType stepType;

    public long cashValue;

    public Set<ShareAmount> shares;

    public Set<SharePrice> sharePrices;

    public Set<ShareCompensation> compensations;

    public Long originalStepId;
}
