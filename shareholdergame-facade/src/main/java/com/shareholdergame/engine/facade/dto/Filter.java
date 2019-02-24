package com.shareholdergame.engine.facade.dto;

/**
 * Date: 10/11/2018
 *
 * @author Aliaksandr Savin
 */
public class Filter {

    private GameOptionFilter gameOptionFilter;

    private String playerName;

    private Filter() {
    }

    public static Filter of(GameOptionFilter gameOptionFilter, String playerName) {
        Filter f = new Filter();
        f.gameOptionFilter = gameOptionFilter;
        f.playerName = playerName;
        return f;
    }

    public GameOptionFilter getGameOptionFilter() {
        return gameOptionFilter;
    }

    public String getPlayerName() {
        return playerName;
    }
}
