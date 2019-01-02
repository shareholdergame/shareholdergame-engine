package com.shareholdergame.engine.account.model;

import java.time.LocalDate;

import org.apache.commons.lang3.builder.Builder;

public final class Account {

    private Long id;

    private String userName;

    private String email;

    private AccountStatus status;

    private LocalDate creationDate;

    private String language;

    private Account() {
    }

    private Account(AccountBuilder builder) {
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

    public static class AccountBuilder implements Builder<Account> {

        private String email;
        private String userName;
        private Long id;
        private AccountStatus status;
        private LocalDate creationDate;
        private String language;

        private AccountBuilder() {
        }

        public AccountBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public AccountBuilder withUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public AccountBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public AccountBuilder withStatus(AccountStatus status) {
            this.status = status;
            return this;
        }

        public AccountBuilder withCreationDate(LocalDate creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public AccountBuilder withLanguage(String language) {
            this.language = language;
            return this;
        }

        @Override
        public Account build() {
            return new Account(this);
        }
    }
}
