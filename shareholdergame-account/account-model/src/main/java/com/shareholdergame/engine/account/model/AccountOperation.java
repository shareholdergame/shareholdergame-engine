package com.shareholdergame.engine.account.model;

import org.apache.commons.lang3.builder.Builder;

/**
 * Date: 01/16/2019
 *
 * @author Aliaksandr Savin
 */
public  final class AccountOperation {

    private Long operationId;

    private Long gamerId;

    private AccountOperation() {
    }

    public AccountOperation(AccountOperationBuilder builder) {
        this.operationId = builder.operationId;
        this.gamerId = builder.gamerId;
    }

    public Long getOperationId() {
        return operationId;
    }

    public Long getGamerId() {
        return gamerId;
    }

    public static AccountOperationBuilder builder() {
        return new AccountOperationBuilder();
    }

    public static class AccountOperationBuilder implements Builder<AccountOperation> {

        private Long operationId;
        private Long gamerId;

        private AccountOperationBuilder() {
        }

        public AccountOperationBuilder withOperationId(Long operationId) {
            this.operationId = operationId;
            return this;
        }

        public AccountOperationBuilder withGamerId(Long gamerId) {
            this.gamerId = gamerId;
            return this;
        }

        @Override
        public AccountOperation build() {
            return new AccountOperation(this);
        }
    }
}
