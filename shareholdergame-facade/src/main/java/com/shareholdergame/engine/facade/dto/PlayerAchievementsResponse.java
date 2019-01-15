package com.shareholdergame.engine.facade.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Date: 10/11/2018
 *
 * @author Aliaksandr Savin
 */
public class PlayerAchievementsResponse {

    private Filter filter;

    private Pagination pagination;

    private List<PlayerAchievements> items;

    @JsonCreator
    public PlayerAchievementsResponse(@JsonProperty("filter") Filter filter,
                                      @JsonProperty("pagination") Pagination pagination,
                                      @JsonProperty("items") List<PlayerAchievements> items) {
        this.filter = filter;
        this.pagination = pagination;
        this.items = items;
    }

    public Filter getFilter() {
        return filter;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public List<PlayerAchievements> getItems() {
        return items;
    }
}
