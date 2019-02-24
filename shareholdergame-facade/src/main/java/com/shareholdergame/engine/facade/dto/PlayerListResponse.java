package com.shareholdergame.engine.facade.dto;

import com.shareholdergame.engine.facade.dto.player.PlayerWithLocation;

import java.util.List;

/**
 * Date: 11/01/2018
 *
 * @author Aliaksandr Savin
 */
public class PlayerListResponse {

    public Pagination pagination;

    public List<PlayerWithLocation> players;
}
