package com.shareholdergame.engine.api.account;

/**
 * Date: 01/15/2019
 *
 * @author Aliaksandr Savin
 */
public final class PasswordUpdate {

    private String oldPassword;

    private String newPassword;

    private PasswordUpdate() {
    }

    private PasswordUpdate(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public static PasswordUpdate of(String oldPassword, String newPassword) {
        return new PasswordUpdate(oldPassword, newPassword);
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
