package com.shareholdergame.engine.account.model;

import org.apache.commons.lang3.builder.Builder;

import java.time.LocalDateTime;

/**
 * Date: 01/16/2019
 *
 * @author Aliaksandr Savin
 */
public final class AccountOperation {

    private Long operationId;

    private Long gamerId;

    private AccountOperationType operationType;

    private String oldValue;

    private String newValue;

    private String verificationCode;

    private LocalDateTime initiationDate;

    private LocalDateTime completionDate;

    private AccountOperationStatus operationStatus;

    private LocalDateTime expirationDate;

    private AccountOperation() {
    }

    public AccountOperation(AccountOperationBuilder builder) {
        this.operationId = builder.operationId;
        this.gamerId = builder.gamerId;
        this.operationType = builder.operationType;
        this.oldValue = builder.oldValue;
        this.newValue = builder.newValue;
        this.verificationCode = builder.verificationCode;
        this.initiationDate = builder.initiationDate;
        this.completionDate = builder.completionDate;
        this.operationStatus = builder.operationStatus;
        this.expirationDate = builder.expirationDate;
    }

    public Long getOperationId() {
        return operationId;
    }

    public Long getGamerId() {
        return gamerId;
    }

    public AccountOperationType getOperationType() {
        return operationType;
    }

    public String getOldValue() {
        return oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public LocalDateTime getInitiationDate() {
        return initiationDate;
    }

    public LocalDateTime getCompletionDate() {
        return completionDate;
    }

    public AccountOperationStatus getOperationStatus() {
        return operationStatus;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public static AccountOperationBuilder builder() {
        return new AccountOperationBuilder();
    }

    public static class AccountOperationBuilder implements Builder<AccountOperation> {

        private Long operationId;
        private Long gamerId;
        private AccountOperationType operationType;
        private String oldValue;
        private String newValue;
        private String verificationCode;
        private LocalDateTime initiationDate;
        private LocalDateTime completionDate;
        private AccountOperationStatus operationStatus;
        private LocalDateTime expirationDate;

        private AccountOperationBuilder() {
        }

        public AccountOperationBuilder operationId(Long operationId) {
            this.operationId = operationId;
            return this;
        }

        public AccountOperationBuilder gamerId(Long gamerId) {
            this.gamerId = gamerId;
            return this;
        }

        public AccountOperationBuilder operationType(AccountOperationType operationType) {
            this.operationType = operationType;
            return this;
        }

        public AccountOperationBuilder oldValue(String oldValue) {
            this.oldValue = oldValue;
            return this;
        }

        public AccountOperationBuilder newValue(String newValue) {
            this.newValue = newValue;
            return this;
        }

        public AccountOperationBuilder verificationCode(String verificationCode) {
            this.verificationCode = verificationCode;
            return this;
        }

        public AccountOperationBuilder initiationDate(LocalDateTime initiationDate) {
            this.initiationDate = initiationDate;
            return this;
        }

        public AccountOperationBuilder completionDate(LocalDateTime completionDate) {
            this.completionDate = completionDate;
            return this;
        }

        public AccountOperationBuilder operationStatus(AccountOperationStatus operationStatus) {
            this.operationStatus = operationStatus;
            return this;
        }

        public AccountOperationBuilder expirationDate(LocalDateTime expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        @Override
        public AccountOperation build() {
            return new AccountOperation(this);
        }
    }
}
