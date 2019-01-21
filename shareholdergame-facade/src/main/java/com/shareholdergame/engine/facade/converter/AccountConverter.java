package com.shareholdergame.engine.facade.converter;

import com.shareholdergame.engine.account.model.GamerAccount;
import com.shareholdergame.engine.facade.dto.AccountDetails;

public class AccountConverter implements Converter<GamerAccount, AccountDetails> {

    @Override
    public AccountDetails convert(GamerAccount gamerAccount) {
        AccountDetails ad = new AccountDetails();
        ad.userName = gamerAccount.getUserName();
        ad.email = gamerAccount.getEmail();
        ad.status = gamerAccount.getStatus().name();
        ad.creationDate = gamerAccount.getCreationDate().toString();
        ad.language = gamerAccount.getLanguage();
        return ad;
    }
}
