package com.shareholdergame.engine.facade.authentication;

import com.google.common.collect.Lists;
import com.shareholdergame.engine.account.model.AccountWithPassword;
import com.shareholdergame.engine.facade.client.AccountClient;
import io.micronaut.security.authentication.AuthenticationFailed;
import io.micronaut.security.authentication.AuthenticationFailureReason;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.micronaut.security.authentication.UserDetails;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Date: 10/19/2018
 *
 * @author Aliaksandr Savin
 */
@Singleton
public class AuthenticationProviderUserPassword implements AuthenticationProvider {

    @Inject
    private AccountClient accountClient;

    @Override
    public Publisher<AuthenticationResponse> authenticate(AuthenticationRequest authenticationRequest) {
        String identity = authenticationRequest.getIdentity().toString();
        String secret = authenticationRequest.getSecret().toString();
        AccountWithPassword accountWithPassword = accountClient.findUserByNameOrEmail(identity);
        if (accountWithPassword != null && isPasswordIdentical(secret, accountWithPassword.getPassword())) {
            return Flowable.just(new UserDetails(accountWithPassword.getAccount().getUserName(), Lists.newArrayList("ROLE_USER")));
        }

        return Flowable.just(new AuthenticationFailed(AuthenticationFailureReason.CREDENTIALS_DO_NOT_MATCH));
    }

    private boolean isPasswordIdentical(String secret, String password) {
        return secret.equals(password);
    }
}
