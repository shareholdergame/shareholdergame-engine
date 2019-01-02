package com.shareholdergame.engine.facade.dto.game;

public class SharePrice {

    private short shareId;

    private long price;

    private Long priceOperationId;

    public short getShareId() {
        return shareId;
    }

    public void setShareId(short shareId) {
        this.shareId = shareId;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Long getPriceOperationId() {
        return priceOperationId;
    }

    public void setPriceOperationId(Long priceOperationId) {
        this.priceOperationId = priceOperationId;
    }
}
