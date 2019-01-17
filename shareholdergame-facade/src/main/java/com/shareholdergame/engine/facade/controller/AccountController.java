package com.shareholdergame.engine.facade.controller;

import com.shareholdergame.engine.account.api.ChangePassword;
import com.shareholdergame.engine.account.api.SignUp;
import com.shareholdergame.engine.account.model.AccountWithPassword;
import com.shareholdergame.engine.common.exception.BusinessException;
import com.shareholdergame.engine.common.exception.Errors;
import com.shareholdergame.engine.common.support.ResponseWrapper;
import com.shareholdergame.engine.facade.client.AccountClient;
import com.shareholdergame.engine.facade.converter.Converters;
import com.shareholdergame.engine.facade.dto.AccountDetails;
import com.shareholdergame.engine.facade.dto.Language;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.exceptions.HttpStatusException;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.validator.constraints.Length;

import javax.inject.Inject;
import javax.validation.constraints.NotBlank;
import java.security.Principal;
import java.util.Optional;

@Controller("/account")
@Validated
@Secured(SecurityRule.IS_AUTHENTICATED)
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Account")
public class AccountController {

    @Inject
    private AccountClient accountClient;

    /**
     * Check user existence.
     * @param userNameOrEmail user name or email
     * @return true if user exists or false if no.
     */
    @Get("/exists/{userNameOrEmail}")
    @Secured(SecurityRule.IS_ANONYMOUS)
    public ResponseWrapper<Boolean> checkUserExistence(@NotBlank String userNameOrEmail) {
        boolean existence = accountClient.checkUserExistence(userNameOrEmail);
        return ResponseWrapper.ok(existence);
    }

    /**
     * Sign user up.
     *
     * @param userName user name
     * @param email email
     * @param password password
     * @param language language
     * @return empty response if ok.
     */
    @Put(value = "/signup", consumes = MediaType.APPLICATION_FORM_URLENCODED)
    @Secured(SecurityRule.IS_ANONYMOUS)
    public ResponseWrapper<?> signup(@QueryValue @NotBlank String userName,
                                     @QueryValue @NotBlank String email,
                                     @QueryValue @NotBlank @Length(min = 6) String password,
                                     @Header Language language) {
        if (accountClient.checkUserExistence(userName) || accountClient.checkUserExistence(email)) {
            throw new BusinessException(Errors.USER_ALREADY_EXISTS.name());
        }

        accountClient.createAccount(SignUp.builder()
                .withUserName(userName).withEmail(email).withPassword(password)
                .withLanguage(Optional.of(language).map(Enum::name).orElse(Language.en.name())).build());
        return ResponseWrapper.ok();
    }

    /**
     * Verify user account.
     * @param verificationCode verification code.
     * @return empty response if ok.
     */
    @Get("/verify/{verificationCode}")
    @Secured(SecurityRule.IS_ANONYMOUS)
    public ResponseWrapper<?> verify(@NotBlank String verificationCode) {
        return ResponseWrapper.ok();
    }

    /**
     * Resets user password.
     * @param email user email.
     * @return empty response if ok.
     */
    @Post("/resetpassword/{email}")
    @Secured(SecurityRule.IS_ANONYMOUS)
    public ResponseWrapper<?> resetPassword(@NotBlank String email) {
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
        return ResponseWrapper.ok();
    }

    /**
     * Changes password.
     * @param oldPassword old password.
     * @param newPassword new password.
     * @param authentication user principal.
     * @return empty response if ok.
     */
    @Post(value = "/change/password", consumes = MediaType.APPLICATION_FORM_URLENCODED)
    public ResponseWrapper<?> changePassword(@QueryValue @NotBlank String oldPassword,
                                             @QueryValue @NotBlank @Length(min = 6) String newPassword,
                                             Authentication authentication) {
        accountClient.changePassword(new ChangePassword(oldPassword, newPassword, authentication.getName()));
        return ResponseWrapper.ok();
    }
}
