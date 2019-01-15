package com.shareholdergame.engine.facade.dto;

import com.shareholdergame.engine.facade.dto.player.Player;
import com.shareholdergame.engine.facade.dto.player.PlayerSession;

import java.io.Serializable;

/**
 * Date: 10/05/2018
 *
 * @author Aliaksandr Savin
 */
public class PlayerAchievements implements Serializable {

    private Player player;

    private Location location;

    private PlayerSession playerSession;

    private Achievements achievements;

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

    public PlayerSession getPlayerSession() {
        return playerSession;
    }

    public void setPlayerSession(PlayerSession playerSession) {
        this.playerSession = playerSession;
    }

    public Achievements getAchievements() {
        return achievements;
    }

    public void setAchievements(Achievements achievements) {
        this.achievements = achievements;
    }
}
