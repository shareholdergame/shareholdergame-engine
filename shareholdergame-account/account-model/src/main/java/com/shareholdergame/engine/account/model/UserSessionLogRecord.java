package com.shareholdergame.engine.account.model;

import org.apache.commons.lang3.builder.Builder;

import java.time.LocalDateTime;

public final class UserSessionLogRecord {

    private Long sessionId;

    private Long gamerId;

    private String ipAddress;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private UserSessionLogRecord() {
    }

    private UserSessionLogRecord(UserSessionLogRecordBuilder builder) {
        gamerId = builder.gamerId;
        ipAddress = builder.ipAddress;
        startTime = builder.startTime;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public Long getGamerId() {
        return gamerId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public static UserSessionLogRecordBuilder builder() {
        return new UserSessionLogRecordBuilder();
    }

    public static class UserSessionLogRecordBuilder implements Builder<UserSessionLogRecord> {
        private Long gamerId;
        private String ipAddress;
        private LocalDateTime startTime;
        private LocalDateTime endTime;

        private UserSessionLogRecordBuilder() {
        }

        public UserSessionLogRecordBuilder gamerId(Long gamerId) {
            this.gamerId = gamerId;
            return this;
        }

        public UserSessionLogRecordBuilder ipAddress(String ipAddress) {
            this.ipAddress = ipAddress;
            return this;
        }

        public UserSessionLogRecordBuilder startTime(LocalDateTime startTime) {
            this.startTime = startTime;
            return this;
        }

        @Override
        public UserSessionLogRecord build() {
            return new UserSessionLogRecord(this);
        }
    }
}
