package com.shareholdergame.engine.facade.dto.game;

public class BuySellOperation {

    private Long shareId;

    private Long number;

    public Long getShareId() {
        return shareId;
    }

    public void setShareId(Long shareId) {
        this.shareId = shareId;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
