package com.shareholdergame.engine.api.account;

/**
 * Date: 01/15/2019
 *
 * @author Aliaksandr Savin
 */
public final class UpdatePassword {

    private String oldPassword;

    private String newPassword;

    private UpdatePassword() {
    }

    private UpdatePassword(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public static UpdatePassword of(String oldPassword, String newPassword) {
        return new UpdatePassword(oldPassword, newPassword);
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
