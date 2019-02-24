package com.shareholdergame.engine.facade.dto;

import java.util.List;

/**
 * Date: 10/11/2018
 *
 * @author Aliaksandr Savin
 */
public class PlayerAchievementsResponse {

    private Filter filter;

    private Pagination pagination;

    private List<PlayerAchievements> items;

    private PlayerAchievementsResponse() {
    }

    public static PlayerAchievementsResponse of(Filter filter, Pagination pagination, List<PlayerAchievements> items) {
        PlayerAchievementsResponse par = new PlayerAchievementsResponse();
        par.filter = filter;
        par.pagination = pagination;
        par.items = items;
        return par;
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
