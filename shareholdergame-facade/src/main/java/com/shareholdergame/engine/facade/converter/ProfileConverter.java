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

        pl.city = profile.getCity();
        pl.country = profile.getCountry();
        pl.stateProvince = profile.getStateProvince();

        ppi.about = profile.getAbout();
        ppi.birthday = profile.getBirthday().toString();

        pp.location = pl;
        pp.personalInfo = ppi;
        return pp;
    }
}
