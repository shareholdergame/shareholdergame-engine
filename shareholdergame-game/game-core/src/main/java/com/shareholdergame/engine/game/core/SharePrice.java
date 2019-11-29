package com.shareholdergame.engine.game.core;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public final class SharePrice implements Comparable<SharePrice> {

    private final Long shareId;

    private Long price = 0L;

    private SharePrice(Long shareId) {
        this.shareId = shareId;
    }

    public Long getShareId() {
        return shareId;
    }

    public Long getPrice() {
        return price;
    }

    public static SharePrice of(Long shareId, Long price) {
        SharePrice sharePrice = new SharePrice(shareId);
        sharePrice.price = price;
        return sharePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SharePrice that = (SharePrice) o;

        return new EqualsBuilder()
                .append(shareId, that.shareId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(shareId)
                .toHashCode();
    }

    @Override
    public int compareTo(SharePrice o) {
        return (int) (this.shareId - o.shareId);
    }
}
