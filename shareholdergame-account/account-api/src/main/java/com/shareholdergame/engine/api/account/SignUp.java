package com.shareholdergame.engine.api.account;

import java.io.Serializable;

import org.apache.commons.lang3.builder.Builder;

/**
 * Date: 01/14/2019
 *
 * @author Aliaksandr Savin
 */
public class SignUp implements Serializable {

    private String userName;

    private String email;

    private String password;

    private String language;

    private String ipAddress;

    private SignUp() {
    }

    private SignUp(SignUpDataBuilder builder) {
        this.userName = builder.userName;
        this.email = builder.email;
        this.password = builder.password;
        this.language = builder.language;
        this.ipAddress = builder.ipAddress;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getLanguage() {
        return language;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public static SignUpDataBuilder builder() {
        return new SignUpDataBuilder();
    }

    public static class SignUpDataBuilder implements Builder<SignUp> {

        private String language;
        private String email;
        private String password;
        private String userName;
        private String ipAddress;

        private SignUpDataBuilder() {
        }

        public SignUpDataBuilder email(String email) {
            this.email = email;
            return this;
        }

        public SignUpDataBuilder password(String password) {
            this.password = password;
            return this;
        }

        public SignUpDataBuilder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public SignUpDataBuilder language(String language) {
            this.language = language;
            return this;
        }

        public SignUpDataBuilder ipAddress(String ipAddress) {
            this.ipAddress = ipAddress;
            return this;
        }

        @Override
        public SignUp build() {
            return new SignUp(this);
        }
    }
}
