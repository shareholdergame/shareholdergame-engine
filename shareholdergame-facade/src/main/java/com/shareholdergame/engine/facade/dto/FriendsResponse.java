package com.shareholdergame.engine.facade.dto;

import com.shareholdergame.engine.facade.dto.player.Player;

import java.util.List;

public class FriendsResponse {

    private Pagination pagination;

    private List<Player> players;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
