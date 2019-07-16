package com.shareholdergame.engine.api.account;

import com.shareholdergame.engine.account.model.GamerAccount;

public interface AccountService {

    boolean checkUserExistence(String userNameOrEmail);

    GamerAccount findUserByNameOrEmail(String userNameOrEmail);

    void createAccount(NewAccount newAccount);

    void changePassword(Long gamerId, PasswordUpdate passwordUpdate);

    void resetPassword(Long gamerId);

    void verify(Long gamerId, String verificationCode);

    void logUserSession(Long gamerId, String ipAddress);
}
