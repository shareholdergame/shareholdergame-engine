package com.shareholdergame.engine.facade.converter;

import com.google.common.collect.ImmutableMap;
import com.shareholdergame.engine.account.model.GamerAccount;
import com.shareholdergame.engine.account.model.Profile;

import java.util.Map;

public final class Converters {

    private static Map<Class<?>, Converter> converterMap = ImmutableMap.<Class<?>, Converter>builder()
            .put(GamerAccount.class, new AccountConverter())
            .put(Profile.class, new ProfileConverter())
            .build();

    private Converters() {
    }

    private static Converter converterOf(Class<?> aClass) {
        return converterMap.getOrDefault(aClass, source -> source);
    }

    public static <S, D> D convert(S source) {
        return (D) converterOf(source.getClass()).convert(source);
    }
}
