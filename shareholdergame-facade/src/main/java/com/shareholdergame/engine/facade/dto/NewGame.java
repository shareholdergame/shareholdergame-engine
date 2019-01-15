package com.shareholdergame.engine.facade.dto;

import java.util.Set;

/**
 * Date: 11/01/2018
 *
 * @author Aliaksandr Savin
 */
public class NewGame {

    private short majorCardsNumber;

    private short minorCardsNumber;

    private Set<String> invitedPlayers;

    public short getMajorCardsNumber() {
        return majorCardsNumber;
    }

    public void setMajorCardsNumber(short majorCardsNumber) {
        this.majorCardsNumber = majorCardsNumber;
    }

    public short getMinorCardsNumber() {
        return minorCardsNumber;
    }

    public void setMinorCardsNumber(short minorCardsNumber) {
        this.minorCardsNumber = minorCardsNumber;
    }

    public Set<String> getInvitedPlayers() {
        return invitedPlayers;
    }

    public void setInvitedPlayers(Set<String> invitedPlayers) {
        this.invitedPlayers = invitedPlayers;
    }
}
