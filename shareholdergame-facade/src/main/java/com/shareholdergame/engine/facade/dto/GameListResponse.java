package com.shareholdergame.engine.facade.dto;

import com.shareholdergame.engine.facade.dto.game.Game;

import java.util.List;

/**
 * Date: 11/01/2018
 *
 * @author Aliaksandr Savin
 */
public class GameListResponse {

    private Pagination pagination;

    private List<Game> games;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
