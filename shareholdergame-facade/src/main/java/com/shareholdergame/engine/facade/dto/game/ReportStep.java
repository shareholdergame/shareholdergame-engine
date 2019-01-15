package com.shareholdergame.engine.facade.dto.game;

import java.util.Set;

public class ReportStep {

    private StepType stepType;

    private long cashValue;

    private Set<ShareAmount> shares;

    private Set<SharePrice> sharePrices;

    private Set<ShareCompensation> compensations;

    private Long originalStepId;

    public StepType getStepType() {
        return stepType;
    }

    public void setStepType(StepType stepType) {
        this.stepType = stepType;
    }

    public long getCashValue() {
        return cashValue;
    }

    public void setCashValue(long cashValue) {
        this.cashValue = cashValue;
    }

    public Set<ShareAmount> getShares() {
        return shares;
    }

    public void setShares(Set<ShareAmount> shares) {
        this.shares = shares;
    }

    public Set<SharePrice> getSharePrices() {
        return sharePrices;
    }

    public void setSharePrices(Set<SharePrice> sharePrices) {
        this.sharePrices = sharePrices;
    }

    public Set<ShareCompensation> getCompensations() {
        return compensations;
    }

    public void setCompensations(Set<ShareCompensation> compensations) {
        this.compensations = compensations;
    }

    public Long getOriginalStepId() {
        return originalStepId;
    }

    public void setOriginalStepId(Long originalStepId) {
        this.originalStepId = originalStepId;
    }
}
