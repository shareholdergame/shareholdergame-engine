package com.shareholdergame.engine.facade.authentication;

import com.google.common.collect.Lists;
import com.shareholdergame.engine.account.model.GamerAccount;
import com.shareholdergame.engine.api.account.AccountService;
import com.shareholdergame.engine.common.util.MD5Helper;
import io.micronaut.security.authentication.AuthenticationFailed;
import io.micronaut.security.authentication.AuthenticationFailureReason;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import javax.inject.Singleton;

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
    public Publisher<AuthenticationResponse> authenticate(AuthenticationRequest authenticationRequest) {
        String identity = authenticationRequest.getIdentity().toString();
        String secret = authenticationRequest.getSecret().toString();
        GamerAccount gamerAccount = accountClient.findUserByNameOrEmail(identity);
        if (gamerAccount != null && isPasswordIdentical(secret, gamerAccount.getPassword())) {
            return Flowable.just(new ExtendedUserDetails(gamerAccount.getUserName(),
                    Lists.newArrayList(ROLE_USER), gamerAccount.getId()));
        }

        return Flowable.just(new AuthenticationFailed(AuthenticationFailureReason.CREDENTIALS_DO_NOT_MATCH));
    }

    private boolean isPasswordIdentical(String secret, String passwordHash) {
        return MD5Helper.checkMD5hash(secret, passwordHash);
    }
}
