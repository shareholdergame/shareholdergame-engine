package com.shareholdergame.engine.account.model.mock;

import com.google.common.collect.Lists;
import com.shareholdergame.engine.account.model.Account;
import com.shareholdergame.engine.account.model.AccountStatus;
import com.shareholdergame.engine.account.model.AccountWithPassword;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class MockDataProvider {

    private static final ArrayList<AccountWithPassword> ACCOUNT_WITH_PASSWORDS = Lists.newArrayList(
            AccountWithPassword.builder()
                    .withAccount(
                            Account.builder().withId(1L)
                                    .withUserName("sergeychernyshev")
                                    .withEmail("player1@shareholdergame.com")
                                    .withStatus(AccountStatus.ACTIVE)
                                    .withCreationDate(LocalDate.of(2015, 8, 1))
                                    .withLanguage("EN")
                                    .build())
                    .withPassword("123456").build(),
            /*AccountWithPassword.builder()
                    .withAccount(
                            Account.builder().withId(1L)
                                    .withUserName("Admin")
                                    .withEmail("player2@shareholdergame.com")
                                    .withStatus(AccountStatus.ACTIVE)
                                    .withCreationDate(LocalDate.of(2015, 8, 1))
                                    .withLanguage("EN")
                                    .build())
                    .withPassword("123456").build(),*/
            AccountWithPassword.builder()
                    .withAccount(
                            Account.builder().withId(1L)
                                    .withUserName("Зырянов")
                                    .withEmail("player3@shareholdergame.com")
                                    .withStatus(AccountStatus.ACTIVE)
                                    .withCreationDate(LocalDate.of(2015, 8, 1))
                                    .withLanguage("RU")
                                    .build())
                    .withPassword("123456").build()
    );

    public static List<AccountWithPassword> getAccountWithPasswordList() {
        return ACCOUNT_WITH_PASSWORDS;
    }
}
