package com.shareholdergame.engine.facade.dto.player;

import com.shareholdergame.engine.facade.dto.Location;

public class ProfileUpdate {

    private Location location;

    private PlayerPersonalInfo personalInfo;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PlayerPersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PlayerPersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }
}
