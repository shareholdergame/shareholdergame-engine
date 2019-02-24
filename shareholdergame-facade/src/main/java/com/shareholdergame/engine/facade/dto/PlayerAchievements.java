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

    public Player player;

    public Location location;

    public PlayerSession playerSession;

    public Achievements achievements;
}
