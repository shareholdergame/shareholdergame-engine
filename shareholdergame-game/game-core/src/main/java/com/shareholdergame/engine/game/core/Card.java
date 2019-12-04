package com.shareholdergame.engine.game.core;

import com.google.common.collect.Sets;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.Builder;

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

    private static class CardBuilder implements Builder<Card> {

        private Long cardId;
        private Set<CardOperation> operations = Sets.newHashSet();

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
