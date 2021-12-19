package com.shareholdergame.engine.facade.authentication;

import com.shareholdergame.engine.api.account.AccountService;
import io.micronaut.context.annotation.Replaces;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.token.jwt.bearer.AccessRefreshTokenLoginHandler;
import io.micronaut.security.token.jwt.generator.AccessRefreshTokenGenerator;

import jakarta.inject.Inject;
import java.net.InetSocketAddress;

@Replaces(AccessRefreshTokenLoginHandler.class)
public class CustomLoginHandler extends AccessRefreshTokenLoginHandler {

    @Inject
    private AccountService accountService;

    /**
     * @param accessRefreshTokenGenerator AccessRefresh Token generator
     */
    public CustomLoginHandler(AccessRefreshTokenGenerator accessRefreshTokenGenerator) {
        super(accessRefreshTokenGenerator);
    }

    @Override
    public MutableHttpResponse<?> loginSuccess(Authentication authentication, HttpRequest<?> request) {
        InetSocketAddress address = request.getRemoteAddress();
        // todo
        return super.loginSuccess(authentication, request);
    }

    /*@Override
    public HttpResponse loginSuccess(UserDetails userDetails, HttpRequest<?> request) {
        InetSocketAddress address = request.getRemoteAddress();
        accountService.logUserSession(((ExtendedUserDetails) userDetails).getId(), address.getAddress().toString());
        return super.loginSuccess(userDetails, request);
    }*/
}
