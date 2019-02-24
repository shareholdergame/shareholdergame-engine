package com.shareholdergame.engine.facade.dto.game;

import com.shareholdergame.engine.facade.dto.player.Player;

public class GamePlayer {

    public Long id;

    public boolean bot;

    public boolean initiator;

    public Player player;

    public PlayerInvitation invitation;
}
