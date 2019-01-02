package com.shareholdergame.engine.facade.converter;

public interface Converter<S, D> {

    D convert(S source);
}
