package com.shareholdergame.engine.game.core.builder;

import org.apache.commons.lang3.builder.Builder;

public class AbstractNestedBuilder<B extends Builder<?>> implements NestedBuilder<B> {

    private B nestedBuilder;

    protected AbstractNestedBuilder(B nestedBuilder) {
        this.nestedBuilder = nestedBuilder;
    }

    public B finish() {
        return nestedBuilder;
    }
}
