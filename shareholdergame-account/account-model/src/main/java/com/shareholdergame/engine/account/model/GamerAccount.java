package com.shareholdergame.engine.account.model;

import org.apache.commons.lang3.builder.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

public final class GamerAccount {

    private Long id;

    private String userName;

    private String email;

    private String password;

    private AccountStatus status;

    private LocalDateTime creationDate;

    private String registeredFromIp;

    private String language;

    private GamerAccount() {
    }

    private GamerAccount(AccountBuilder builder) {
        this.id = builder.id;
        this.userName = builder.userName;
        this.email = builder.email;
        this.password = builder.password;
        this.status = builder.status;
        this.creationDate = builder.creationDate;
        this.registeredFromIp = builder.registeredFromIp;
        this.language = builder.language;
    }

    public Long getId() {
        return id;
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

    public AccountStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getRegisteredFromIp() {
        return registeredFromIp;
    }

    public String getLanguage() {
        return language;
    }

    public static AccountBuilder builder() {
        return new AccountBuilder();
    }

    public static class AccountBuilder implements Builder<GamerAccount> {

        private Long id;
        private String email;
        private String userName;
        private String password;
        private AccountStatus status;
        private LocalDateTime creationDate;
        private String registeredFromIp;
        private String language;

        private AccountBuilder() {
        }

        public AccountBuilder email(String email) {
            this.email = email;
            return this;
        }

        public AccountBuilder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public AccountBuilder password(String password) {
            this.password = password;
            return this;
        }

        public AccountBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public AccountBuilder status(AccountStatus status) {
            this.status = status;
            return this;
        }

        public AccountBuilder creationDate(LocalDateTime creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public AccountBuilder registeredFromIp(String registeredFromIp) {
            this.registeredFromIp = registeredFromIp;
            return this;
        }

        public AccountBuilder language(String language) {
            this.language = language;
            return this;
        }

        @Override
        public GamerAccount build() {
            return new GamerAccount(this);
        }
    }
}
