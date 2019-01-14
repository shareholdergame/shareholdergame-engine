package com.shareholdergame.engine.account.api;

import java.io.Serializable;

import org.apache.commons.lang3.builder.Builder;

/**
 * Date: 01/14/2019
 *
 * @author Aliaksandr Savin
 */
public class SignUpData implements Serializable {

    private String userName;

    private String email;

    private String password;

    private String language;

    private SignUpData() {
    }

    private SignUpData(SignUpDataBuilder builder) {
        this.userName = builder.userName;
        this.email = builder.email;
        this.password = builder.password;
        this.language = builder.language;
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

    public static SignUpDataBuilder builder() {
        return new SignUpDataBuilder();
    }

    public static class SignUpDataBuilder implements Builder<SignUpData> {

        private String language;
        private String email;
        private String password;
        private String userName;

        private SignUpDataBuilder() {
        }

        public SignUpDataBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public SignUpDataBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public SignUpDataBuilder withUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public SignUpDataBuilder withLanguage(String language) {
            this.language = language;
            return this;
        }

        @Override
        public SignUpData build() {
            return new SignUpData(this);
        }
    }
}
