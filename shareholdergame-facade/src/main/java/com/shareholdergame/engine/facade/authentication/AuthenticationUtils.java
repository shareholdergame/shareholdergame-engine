package com.shareholdergame.engine.facade.authentication;

import io.micronaut.security.authentication.Authentication;

public final class AuthenticationUtils {

    private AuthenticationUtils() {
    }

    public static Long getGamerId(Authentication authentication) {
        return (Long) authentication.getAttributes().get(AuthenticationConstants.ACCOUNT_ID);
    }
}
