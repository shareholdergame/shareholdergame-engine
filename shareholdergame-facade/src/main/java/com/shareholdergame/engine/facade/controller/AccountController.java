package com.shareholdergame.engine.facade.controller;

import com.shareholdergame.engine.api.account.AccountService;
import com.shareholdergame.engine.api.account.PasswordUpdate;
import com.shareholdergame.engine.api.account.NewAccount;
import com.shareholdergame.engine.account.model.AccountWithPassword;
import com.shareholdergame.engine.common.http.ResponseWrapper;
import com.shareholdergame.engine.facade.authentication.AuthenticationConstants;
import com.shareholdergame.engine.facade.converter.Converters;
import com.shareholdergame.engine.facade.dto.AccountDetails;
import com.shareholdergame.engine.facade.dto.Language;
import com.shareholdergame.engine.facade.dto.SignUp;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.http.exceptions.HttpStatusException;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.inject.Inject;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.Optional;

@Controller("/account")
@Validated
@Secured(SecurityRule.IS_AUTHENTICATED)
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Account")
public class AccountController {

    @Inject
    private AccountService accountClient;

    /**
     * Check user existence.
     * @param userNameOrEmail user name or email
     * @return true if user exists or false if no.
     */
    @Get("/exists/{userNameOrEmail}")
    @Secured(SecurityRule.IS_ANONYMOUS)
    public ResponseWrapper<Boolean> checkUserExistence(@NotBlank String userNameOrEmail) {
        return ResponseWrapper.ok(accountClient.checkUserExistence(userNameOrEmail));
    }

    /**
     * Sign user up.
     *
     * @param signUp sign up data: user name, email and password
     * @param language language
     * @return empty response if ok.
     */
    @Put("/signup")
    @Secured(SecurityRule.IS_ANONYMOUS)
    public ResponseWrapper<?> signup(@NotNull @Body SignUp signUp,
                                     @Header Language language,
                                     HttpRequest httpRequest) {
        accountClient.createAccount(NewAccount.builder()
                .userName(signUp.userName)
                .email(signUp.email)
                .password(signUp.password)
                .ipAddress(httpRequest.getRemoteAddress().getAddress().toString())
                .language(Optional.of(language).map(Enum::name).orElse(Language.en.name())).build());

        return ResponseWrapper.ok();
    }

    /**
     * Verify user account.
     * @param verificationCode verification code.
     * @return empty response if ok or 404 if account not existed or verification is not applicable to this account.
     */
    @Post("/verify/{verificationCode}")
    public ResponseWrapper<?> verify(@NotBlank String verificationCode, Authentication authentication) {
        accountClient.verify(getGamerId(authentication), verificationCode);
        return ResponseWrapper.ok();
    }

    /**
     * Resets user password.
     * @param email user email.
     * @return empty response if ok or 404 if account not found.
     */
    @Post("/resetpassword/{email}")
    @Secured(SecurityRule.IS_ANONYMOUS)
    public ResponseWrapper<?> resetPassword(@NotBlank String email) {
        AccountWithPassword accountWithPassword = accountClient.findUserByNameOrEmail(email);
        if (null == accountWithPassword) {
            throw new HttpStatusException(HttpStatus.NOT_FOUND, email);
        }
        accountClient.resetPassword(accountWithPassword.getGamerAccount().getId());
        return ResponseWrapper.ok();
    }

    /**
     * Returns user's account.
     * User must be authenticated to invoke this call.
     * @param principal user principal.
     * @return account details.
     */
    @Get
    public ResponseWrapper<AccountDetails> getAccount(Principal principal) {
        AccountWithPassword accountWithPassword = accountClient.findUserByNameOrEmail(principal.getName());
        if (null == accountWithPassword) {
            throw new HttpStatusException(HttpStatus.NOT_FOUND, principal.getName());
        }
        return ResponseWrapper.ok(Converters.convert(accountWithPassword.getGamerAccount()));
    }

    /**
     * Starts account removing process.
     * User must be authenticated to invoke this call.
     * @param principal user principal.
     * @return empty response if ok.
     */
    @Delete("/remove")
    public ResponseWrapper<?> removeAccount(Principal principal) {
        return ResponseWrapper.ok();
    }

    /**
     * Starts account restoring process.
     * User must be authenticated to invoke this call.
     * @param principal user principal.
     * @return empty response if ok.
     */
    @Post("/restore")
    public ResponseWrapper<?> restoreAccount(Principal principal) {
        return ResponseWrapper.ok();
    }

    /**
     * Updates user's email.
     * User must be authenticated to invoke this call.
     * @param newEmail new email.
     * @param principal user principal.
     * @return empty response if ok.
     */
    @Post(value = "/change/email/{newEmail}", consumes = MediaType.APPLICATION_FORM_URLENCODED)
    public ResponseWrapper<?> changeEmail(@NotBlank String newEmail, Principal principal) {
        // todo = check new email existence


        return ResponseWrapper.ok();
    }

    /**
     * Updates user name.
     * @param newUserName new user name.
     * @param principal user principal.
     * @return empty response if ok.
     */
    @Post(value = "/change/username/{newUserName}", consumes = MediaType.APPLICATION_FORM_URLENCODED)
    public ResponseWrapper<?> changeUserName(@NotBlank String newUserName, Principal principal) {
        // todo - check user name existence

        return ResponseWrapper.ok();
    }

    /**
     * Changes password.
     * @param passwordUpdate old password.
     * @param authentication user principal.
     * @return empty response if ok.
     */
    @Post(value = "/change/password")
    public ResponseWrapper<?> changePassword(@Body PasswordUpdate passwordUpdate, Authentication authentication) {
        accountClient.changePassword(getGamerId(authentication), passwordUpdate);
        return ResponseWrapper.ok();
    }

    private Long getGamerId(Authentication authentication) {
        return (Long) authentication.getAttributes().get(AuthenticationConstants.ACCOUNT_ID);
    }
}
