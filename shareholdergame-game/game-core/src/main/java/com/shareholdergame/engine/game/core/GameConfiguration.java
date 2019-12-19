package com.shareholdergame.engine.game.core;

import com.google.common.collect.Sets;
import com.sun.org.apache.xerces.internal.impl.dv.ValidatedInfo;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.Builder;

import java.util.Collections;
import java.util.Set;

public final class GameConfiguration {

    private Set<Color> colors;

    private CardSet cardSet;

    private PriceScale priceScale;

    private double cashInitialValue;

    private GameConfiguration(GameConfigurationBuilder builder) {
        this.colors = builder.colors;
        this.cardSet = builder.cardSet;
        this.priceScale = builder.priceScale;
        this.cashInitialValue = builder.cashInitialValue;
    }

    public static GameConfigurationBuilder builder() {
        return new GameConfigurationBuilder();
    }

    public Set<Color> getColors() {
        return Collections.unmodifiableSet(colors);
    }

    public CardSet getCardSet() {
        return cardSet;
    }

    public PriceScale getPriceScale() {
        return priceScale;
    }

    public double getCashInitialValue() {
        return cashInitialValue;
    }

    public static class GameConfigurationBuilder implements Builder<GameConfiguration> {

        private Set<Color> colors = Sets.newHashSet();
        private CardSet cardSet;
        private PriceScale priceScale;
        private double cashInitialValue;

        private GameConfigurationBuilder() {
        }

        public GameConfigurationBuilder addColor(Color color) {
            colors.add(color);
            return this;
        }

        public GameConfigurationBuilder cardSet(CardSet cardSet) {
            this.cardSet = cardSet;
            return this;
        }

        public GameConfigurationBuilder priceScale(PriceScale priceScale) {
            this.priceScale = priceScale;
            return this;
        }

        public GameConfigurationBuilder cashInitialValue(double cashInitialValue) {
            this.cashInitialValue = cashInitialValue;
            return this;
        }

        @Override
        public GameConfiguration build() {
            Validate.notNull(priceScale);
            Validate.notNull(cardSet);
            Validate.notEmpty(colors);
            Validate.isTrue(cashInitialValue >= 0.0);
            return new GameConfiguration(this);
        }
    }
}
