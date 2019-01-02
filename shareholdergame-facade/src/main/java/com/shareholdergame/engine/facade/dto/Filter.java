package com.shareholdergame.engine.facade.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Date: 10/11/2018
 *
 * @author Aliaksandr Savin
 */
public class Filter {

    private GameOptionFilter gameOptionFilter;

    private String playerName;

    @JsonCreator
    public Filter(@JsonProperty("gameOptionFilter") GameOptionFilter gameOptionFilter, @JsonProperty("playerName") String playerName) {
        this.gameOptionFilter = gameOptionFilter;
        this.playerName = playerName;
    }

    public GameOptionFilter getGameOptionFilter() {
        return gameOptionFilter;
    }

    public String getPlayerName() {
        return playerName;
    }
}
