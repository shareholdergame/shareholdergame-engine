package com.shareholdergame.engine.account.model;

import org.apache.commons.lang3.builder.Builder;

/**
 * Date: 10/19/2018
 *
 * @author Aliaksandr Savin
 */
public final class AccountWithPassword {

    private Account account;

    private String password;

    private AccountWithPassword() {
    }

    private AccountWithPassword(AccountWithPasswordBuilder builder) {
        this.password = builder.password;
        this.account = builder.account;
    }

    public Account getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public static AccountWithPasswordBuilder builder() {
        return new AccountWithPasswordBuilder();
    }

    public static class AccountWithPasswordBuilder implements Builder<AccountWithPassword> {

        private Account account;
        private String password;

        private AccountWithPasswordBuilder() {
        }

        public AccountWithPasswordBuilder withAccount(Account account) {
            this.account = account;
            return this;
        }

        public AccountWithPasswordBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        @Override
        public AccountWithPassword build() {
            return new AccountWithPassword(this);
        }
    }
}
