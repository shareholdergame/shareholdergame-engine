package com.shareholdergame.engine.game.core;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public final class ShareQuantity implements Comparable<ShareQuantity> {

    private final Long shareId;

    private Long quantity = 0L;

    private ShareQuantity(Long shareId) {
        this.shareId = shareId;
    }

    public Long getShareId() {
        return shareId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public static ShareQuantity of(Long shareId, Long quantity) {
        ShareQuantity shareQuantity = new ShareQuantity(shareId);
        shareQuantity.quantity = quantity;
        return shareQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ShareQuantity that = (ShareQuantity) o;

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
    public int compareTo(ShareQuantity o) {
        return (int) (this.shareId - o.shareId);
    }
}
