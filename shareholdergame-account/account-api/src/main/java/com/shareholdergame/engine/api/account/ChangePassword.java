package com.shareholdergame.engine.api.account;

/**
 * Date: 01/15/2019
 *
 * @author Aliaksandr Savin
 */
public final class ChangePassword {

    private String oldPassword;

    private String newPassword;

    private ChangePassword() {
    }

    private ChangePassword(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public static ChangePassword of(String oldPassword, String newPassword) {
        return new ChangePassword(oldPassword, newPassword);
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
