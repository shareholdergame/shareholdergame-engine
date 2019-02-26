package com.shareholdergame.engine.account.model;

import org.apache.commons.lang3.builder.Builder;

import java.time.LocalDate;

public final class GamerAccount {

    private Long id;

    private String userName;

    private String email;

    private AccountStatus status;

    private LocalDate creationDate;

    private String language;

    private GamerAccount() {
    }

    private GamerAccount(AccountBuilder builder) {
        this.id = builder.id;
        this.userName = builder.userName;
        this.email = builder.email;
        this.status = builder.status;
        this.creationDate = builder.creationDate;
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

    public AccountStatus getStatus() {
        return status;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getLanguage() {
        return language;
    }

    public static AccountBuilder builder() {
        return new AccountBuilder();
    }

    public static class AccountBuilder implements Builder<GamerAccount> {

        private String email;
        private String userName;
        private Long id;
        private AccountStatus status;
        private LocalDate creationDate;
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

        public AccountBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public AccountBuilder status(AccountStatus status) {
            this.status = status;
            return this;
        }

        public AccountBuilder creationDate(LocalDate creationDate) {
            this.creationDate = creationDate;
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
