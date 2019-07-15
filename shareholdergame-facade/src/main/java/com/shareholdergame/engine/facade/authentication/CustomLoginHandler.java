package com.shareholdergame.engine.facade.authentication;

import com.shareholdergame.engine.api.account.AccountService;
import io.micronaut.context.annotation.Replaces;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.security.authentication.UserDetails;
import io.micronaut.security.token.jwt.bearer.AccessRefreshTokenLoginHandler;
import io.micronaut.security.token.jwt.generator.AccessRefreshTokenGenerator;

import javax.inject.Inject;
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
    public HttpResponse loginSuccess(UserDetails userDetails, HttpRequest<?> request) {
        InetSocketAddress address = request.getRemoteAddress();
        accountService.logUserSession(((ExtendedUserDetails) userDetails).getId(), address.getAddress().toString());
        return super.loginSuccess(userDetails, request);
    }
}
