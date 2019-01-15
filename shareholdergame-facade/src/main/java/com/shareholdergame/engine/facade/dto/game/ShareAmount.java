package com.shareholdergame.engine.facade.dto.game;

public class ShareAmount {

    private short shareId;

    private long amount;

    private long buySellAmount;

    public short getShareId() {
        return shareId;
    }

    public void setShareId(short shareId) {
        this.shareId = shareId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getBuySellAmount() {
        return buySellAmount;
    }

    public void setBuySellAmount(long buySellAmount) {
        this.buySellAmount = buySellAmount;
    }
}
