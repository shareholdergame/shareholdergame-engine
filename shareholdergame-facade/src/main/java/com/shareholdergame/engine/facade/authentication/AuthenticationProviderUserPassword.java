package com.shareholdergame.engine.facade.authentication;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.shareholdergame.engine.account.model.GamerAccount;
import com.shareholdergame.engine.api.account.AccountService;
import com.shareholdergame.engine.common.util.MD5Helper;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import org.reactivestreams.Publisher;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import static com.shareholdergame.engine.facade.authentication.AuthenticationConstants.ROLE_USER;

/**
 * Date: 10/19/2018
 *
 * @author Aliaksandr Savin
 */
@Singleton
public class AuthenticationProviderUserPassword implements AuthenticationProvider {

    @Inject
    private AccountService accountClient;

    @Override
    public Publisher<AuthenticationResponse> authenticate(HttpRequest<?> httpRequest,
                                                          AuthenticationRequest<?, ?> authenticationRequest) {
        String identity = authenticationRequest.getIdentity().toString();
        String secret = authenticationRequest.getSecret().toString();
        GamerAccount gamerAccount = accountClient.findUserByNameOrEmail(identity);
        return Flux.create(emitter -> {
            if (gamerAccount != null && isPasswordIdentical(secret, gamerAccount.getPassword())) {
                emitter.next(AuthenticationResponse.success(gamerAccount.getUserName(), Lists.newArrayList(ROLE_USER),
                        ImmutableMap.of(AuthenticationConstants.ACCOUNT_ID, gamerAccount.getId())));
                emitter.complete();
            }
        }, FluxSink.OverflowStrategy.ERROR);
    }

    private boolean isPasswordIdentical(String secret, String passwordHash) {
        return MD5Helper.checkMD5hash(secret, passwordHash);
    }
}
