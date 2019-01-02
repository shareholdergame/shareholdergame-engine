package com.shareholdergame.engine.facade.converter;

import com.shareholdergame.engine.account.model.Account;
import com.shareholdergame.engine.facade.dto.AccountDetails;

public class AccountConverter implements Converter<Account, AccountDetails> {

    @Override
    public AccountDetails convert(Account account) {
        AccountDetails ad = new AccountDetails();
        ad.setUserName(account.getUserName());
        ad.setEmail(account.getEmail());
        ad.setStatus(account.getStatus().name());
        ad.setCreationDate(account.getCreationDate().toString());
        ad.setLanguage(account.getLanguage());
        return ad;
    }
}
