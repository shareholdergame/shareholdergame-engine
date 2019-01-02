package com.shareholdergame.engine.facade.dto.player;

import com.shareholdergame.engine.facade.dto.Location;

/**
 * Date: 10/29/2018
 *
 * @author Aliaksandr Savin
 */
public class PlayerWithLocation {

    private Player player;

    private Location location;

    public PlayerWithLocation(Player player, Location location) {
        this.player = player;
        this.location = location;
    }

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
}
