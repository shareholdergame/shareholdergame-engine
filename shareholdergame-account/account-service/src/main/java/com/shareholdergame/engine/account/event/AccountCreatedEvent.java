package com.shareholdergame.engine.account.event;

import com.shareholdergame.engine.account.model.GamerAccount;
import com.shareholdergame.engine.common.event.BusinessEvent;

public class AccountCreatedEvent extends BusinessEvent<AccountServiceEventType, GamerAccount> {

    private AccountCreatedEvent(GamerAccount gamerAccount) {
        super(AccountServiceEventType.ACCOUNT_CREATED, gamerAccount);
    }

    public static AccountCreatedEvent of(GamerAccount gamerAccount) {
        return new AccountCreatedEvent(gamerAccount);
    }
}
