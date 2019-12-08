package com.shareholdergame.engine.game.core;

import com.google.common.collect.Sets;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.Builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Collections;
import java.util.Set;

public final class Card {

    private Long cardId;

    private Set<CardOperation> operations;

    private Card(CardBuilder cardBuilder) {
        this.cardId = cardBuilder.cardId;
        this.operations = cardBuilder.operations;
    }

    public static CardBuilder builder() {
        return new CardBuilder();
    }

    public Long getCardId() {
        return cardId;
    }

    public Set<CardOperation> getOperations() {
        return Collections.unmodifiableSet(operations);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Card that = (Card) o;

        return new EqualsBuilder()
                .append(cardId, that.cardId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(cardId)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("cardId", cardId).build();
    }

    static class CardBuilder implements Builder<Card> {

        private Long cardId;
        private Set<CardOperation> operations = Sets.newHashSet();

        private CardBuilder() {
        }

        public CardBuilder cardId(Long cardId) {
            this.cardId = cardId;
            return this;
        }

        public CardBuilder addOperation(CardOperation cardOperation) {
            operations.add(cardOperation);
            return this;
        }

        @Override
        public Card build() {
            Validate.notEmpty(operations);
            Validate.notNull(cardId);
            return new Card(this);
        }
    }
}
