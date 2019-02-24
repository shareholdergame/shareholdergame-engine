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

    private List<Game> items;

    private GameListResponse() {
    }

    public static GameListResponse of(List<Game> items, Pagination pagination) {
        GameListResponse glr = new GameListResponse();
        glr.items = items;
        glr.pagination = pagination;
        return glr;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public List<Game> getItems() {
        return items;
    }
}
