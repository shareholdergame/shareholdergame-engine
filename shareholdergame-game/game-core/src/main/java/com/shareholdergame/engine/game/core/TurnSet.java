package com.shareholdergame.engine.game.core;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class TurnSet {

    private Map<TurnKey, TurnRecord> turns = Maps.newTreeMap();

    public Set<TurnRecord> getByTurnOrder(int turnOrder) {
        return turns.entrySet().stream()
                .filter(turnRecordEntry -> turnRecordEntry.getKey().getTurnNumber() == turnOrder)
                .map(Map.Entry::getValue)
                .collect(Collectors.toSet());
    }

    public void addTurn(TurnRecord turnRecord) {
        TurnKey turnKey = new TurnKey(turnRecord.getRoundNumber(), turnRecord.getTurnNumber());
        turns.putIfAbsent(turnKey, turnRecord);
    }

    private static class TurnKey implements Comparable<TurnKey> {

        private int roundNumber;
        private int turnNumber;

        TurnKey(int roundNumber, int turnNumber) {
            this.roundNumber = roundNumber;
            this.turnNumber = turnNumber;
        }

        public int getRoundNumber() {
            return roundNumber;
        }

        public int getTurnNumber() {
            return turnNumber;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            TurnKey that = (TurnKey) o;

            return new EqualsBuilder()
                    .append(roundNumber, that.roundNumber)
                    .append(turnNumber, that.turnNumber)
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37)
                    .append(roundNumber)
                    .append(turnNumber)
                    .toHashCode();
        }

        @Override
        public int compareTo(TurnKey turnKey) {
            int result = this.roundNumber - turnKey.roundNumber;
            if (result == 0) {
                result = this.turnNumber - turnKey.turnNumber;
            }
            return result;
        }
    }
}
