package com.shareholdergame.engine.account.model;

import org.apache.commons.lang3.builder.Builder;

/**
 * Date: 10/19/2018
 *
 * @author Aliaksandr Savin
 */
public final class AccountWithPassword {

    private GamerAccount gamerAccount;

    private String password;

    private AccountWithPassword() {
    }

    private AccountWithPassword(AccountWithPasswordBuilder builder) {
        this.password = builder.password;
        this.gamerAccount = builder.gamerAccount;
    }

    public GamerAccount getGamerAccount() {
        return gamerAccount;
    }

    public String getPassword() {
        return password;
    }

    public static AccountWithPasswordBuilder builder() {
        return new AccountWithPasswordBuilder();
    }

    public static class AccountWithPasswordBuilder implements Builder<AccountWithPassword> {

        private GamerAccount gamerAccount;
        private String password;

        private AccountWithPasswordBuilder() {
        }

        public AccountWithPasswordBuilder account(GamerAccount gamerAccount) {
            this.gamerAccount = gamerAccount;
            return this;
        }

        public AccountWithPasswordBuilder password(String password) {
            this.password = password;
            return this;
        }

        @Override
        public AccountWithPassword build() {
            return new AccountWithPassword(this);
        }
    }
}
