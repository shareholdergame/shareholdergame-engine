package com.shareholdergame.engine.facade.converter;

import com.shareholdergame.engine.account.model.Profile;
import com.shareholdergame.engine.facade.dto.Location;
import com.shareholdergame.engine.facade.dto.player.PlayerPersonalInfo;
import com.shareholdergame.engine.facade.dto.player.PlayerProfile;

public class ProfileConverter implements Converter<Profile, PlayerProfile> {

    @Override
    public PlayerProfile convert(Profile profile) {
        PlayerProfile pp = new PlayerProfile();
        Location pl = new Location();
        PlayerPersonalInfo ppi = new PlayerPersonalInfo();

        pl.setCity(profile.getCity());
        pl.setCountry(profile.getCountry());
        pl.setStateProvince(profile.getStateProvince());

        ppi.setAbout(profile.getAbout());
        ppi.setBirthday(profile.getBirthday().toString());

        pp.setLocation(pl);
        pp.setPersonalInfo(ppi);
        return pp;
    }
}
