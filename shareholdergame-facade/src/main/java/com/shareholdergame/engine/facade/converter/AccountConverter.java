package com.shareholdergame.engine.facade.converter;

import com.shareholdergame.engine.account.model.GamerAccount;
import com.shareholdergame.engine.facade.dto.AccountDetails;

public class AccountConverter implements Converter<GamerAccount, AccountDetails> {

    @Override
    public AccountDetails convert(GamerAccount gamerAccount) {
        AccountDetails ad = new AccountDetails();
        ad.setUserName(gamerAccount.getUserName());
        ad.setEmail(gamerAccount.getEmail());
        ad.setStatus(gamerAccount.getStatus().name());
        ad.setCreationDate(gamerAccount.getCreationDate().toString());
        ad.setLanguage(gamerAccount.getLanguage());
        return ad;
    }
}
