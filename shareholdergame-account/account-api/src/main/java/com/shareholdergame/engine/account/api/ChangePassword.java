package com.shareholdergame.engine.account.api;

/**
 * Date: 01/15/2019
 *
 * @author Aliaksandr Savin
 */
public final class ChangePassword {

    private String oldPassword;

    private String newPassword;

    private String currentUser;

    private ChangePassword() {
    }

    public ChangePassword(String oldPassword, String newPassword, String currentUser) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.currentUser = currentUser;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getCurrentUser() {
        return currentUser;
    }
}
