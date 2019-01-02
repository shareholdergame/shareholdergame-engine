package com.shareholdergame.engine.facade.dto.player;

import com.shareholdergame.engine.facade.dto.Location;

public class PlayerProfile {

    private Player player;

    private Location location;

    private PlayerPersonalInfo personalInfo;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

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
