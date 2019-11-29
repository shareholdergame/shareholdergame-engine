package com.shareholdergame.engine.game.core.builder;

import org.apache.commons.lang3.builder.Builder;

interface NestedBuilder<B extends Builder<?>> {

    B finish();
}
