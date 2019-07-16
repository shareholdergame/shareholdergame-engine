package com.shareholdergame.engine.account.model;

import org.apache.commons.lang3.builder.Builder;

import java.time.LocalDateTime;

public final class Friend {

    private Long gamerId;

    private Long friendId;

    private FriendshipStatus friendshipStatus;

    private LocalDateTime requestedDate;

    private LocalDateTime acceptedDate;

    private Friend() {
    }

    private Friend(FriendBuilder builder) {
        gamerId = builder.gamerId;
        friendId = builder.friendId;
        friendshipStatus = FriendshipStatus.REQUESTED;
        requestedDate = builder.requestedDate;
    }

    public Long getGamerId() {
        return gamerId;
    }

    public Long getFriendId() {
        return friendId;
    }

    public FriendshipStatus getFriendshipStatus() {
        return friendshipStatus;
    }

    public void setFriendshipStatus(FriendshipStatus friendshipStatus) {
        this.friendshipStatus = friendshipStatus;
    }

    public LocalDateTime getRequestedDate() {
        return requestedDate;
    }

    public LocalDateTime getAcceptedDate() {
        return acceptedDate;
    }

    public static FriendBuilder builder() {
        return new FriendBuilder();
    }

    public void setAcceptedDate(LocalDateTime acceptedDate) {
        this.acceptedDate = acceptedDate;
    }

    public static class FriendBuilder implements Builder<Friend> {
        private Long gamerId;
        private Long friendId;
        private LocalDateTime requestedDate;

        private FriendBuilder() {
        }

        public FriendBuilder gamerId(Long gamerId) {
            this.gamerId = gamerId;
            return this;
        }

        public FriendBuilder friendId(Long friendId) {
            this.friendId = friendId;
            return this;
        }

        public FriendBuilder requestedDate(LocalDateTime requestedDate) {
            this.requestedDate = requestedDate;
            return this;
        }

        @Override
        public Friend build() {
            return new Friend(this);
        }
    }
}
