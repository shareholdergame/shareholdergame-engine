package com.shareholdergame.engine.game.core;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.Builder;

public class TurnRecord {

    private int roundNumber;

    private int turnNumber;

    private BuySellStepResult zeroStep;

    private BuySellStepResult firstStepResult;

    private BuySellStepResult lastStepResult;

    private TurnRecord(TurnRecordBuilder builder) {
        this.roundNumber = builder.roundNumber;
        this.turnNumber = builder.turnNumber;
        this.zeroStep = builder.zeroStep;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public static TurnRecordBuilder builder() {
        return new TurnRecordBuilder();
    }

    public static class TurnRecordBuilder implements Builder<TurnRecord> {

        private int roundNumber;
        private int turnNumber;
        private BuySellStepResult zeroStep;
        private BuySellStepResult firstStepResult;
        private BuySellStepResult lastStepResult;

        public TurnRecordBuilder roundNumber(int roundNumber) {
            this.roundNumber = roundNumber;
            return this;
        }

        public TurnRecordBuilder turnNumber(int turnNumber) {
            this.turnNumber = turnNumber;
            return this;
        }

        public TurnRecordBuilder zeroStep(BuySellStepResult stepResult) {
            this.zeroStep = stepResult;
            return this;
        }

        @Override
        public TurnRecord build() {
            Validate.isTrue(roundNumber >= 0);
            Validate.isTrue(turnNumber >= 0);
            Validate.isTrue(roundNumber == 0 && zeroStep != null);

            return new TurnRecord(this);
        }
    }
}
