package com.shareholdergame.engine.api.account;

import com.shareholdergame.engine.account.model.AccountOperation;
import com.shareholdergame.engine.account.model.AccountWithPassword;

public interface AccountService {

    boolean checkUserExistence(String userNameOrEmail);

    AccountWithPassword findUserByNameOrEmail(String userNameOrEmail);

    void createAccount(NewAccount newAccount);

    void changePassword(Long gamerId, PasswordUpdate passwordUpdate);

    void resetPassword(Long gamerId);

    void verify(Long gamerId, String verificationCode);
}
