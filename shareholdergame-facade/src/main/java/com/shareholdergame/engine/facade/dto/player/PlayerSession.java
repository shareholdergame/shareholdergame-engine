package com.shareholdergame.engine.facade.dto.player;

/**
 * Date: 10/11/2018
 *
 * @author Aliaksandr Savin
 */
public class PlayerSession {

    private Long lastVisit;

    private Long lastPlay;

    public Long getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Long lastVisit) {
        this.lastVisit = lastVisit;
    }

    public Long getLastPlay() {
        return lastPlay;
    }

    public void setLastPlay(Long lastPlay) {
        this.lastPlay = lastPlay;
    }
}
