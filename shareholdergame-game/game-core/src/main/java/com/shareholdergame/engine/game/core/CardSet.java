package com.shareholdergame.engine.game.core;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.builder.Builder;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public final class CardSet {

    private Map<CardGroup, Set<Card>> cards;

    private CardSet(CardSetBuilder builder) {
        cards = builder.cards;
    }

    public static CardSetBuilder builder() {
        return new CardSetBuilder();
    }

    public Set<Card> getMajorCards() {
        return Collections.unmodifiableSet(cards.get(CardGroup.MAJOR));
    }

    public Set<Card> getMinorCards() {
        return Collections.unmodifiableSet(cards.get(CardGroup.MINOR));
    }

    public static class CardSetBuilder implements Builder<CardSet> {

        private Map<CardGroup, Set<Card>> cards = ImmutableMap.<CardGroup, Set<Card>>builder()
                .put(CardGroup.MAJOR, Sets.newHashSet())
                .put(CardGroup.MINOR, Sets.newHashSet())
                .build();

        private CardSetBuilder() {
        }

        public CardSetBuilder addMajorCard(Card card) {
            cards.get(CardGroup.MAJOR).add(card);
            return this;
        }

        public CardSetBuilder addMinorCard(Card card) {
            cards.get(CardGroup.MINOR).add(card);
            return this;
        }

        @Override
        public CardSet build() {
            return new CardSet(this);
        }
    }
}
