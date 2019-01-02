package com.shareholdergame.engine.facade.dto;

import com.shareholdergame.engine.facade.dto.player.PlayerWithLocation;

import java.util.List;

/**
 * Date: 11/01/2018
 *
 * @author Aliaksandr Savin
 */
public class PlayerListResponse {

    private Pagination pagination;

    private List<PlayerWithLocation> players;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<PlayerWithLocation> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerWithLocation> players) {
        this.players = players;
    }
}
