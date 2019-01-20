package com.shareholdergame.engine.account.model;

import org.apache.commons.lang3.builder.Builder;

/**
 * Date: 01/16/2019
 *
 * @author Aliaksandr Savin
 */
public  final class AccountOperation {

    /*
    operation_type char(16) not null check (operation_type in ('CHANGE_STATUS', 'CHANGE_USERNAME', 'CHANGE_EMAIL', 'CHANGE_PASSWORD')),
  old_value char(255),
  new_value char(255),
  verification_code char(64),
  initiation_date datetime not null,
  completion_date datetime,
  operation_status char(16) not null check (operation_status in ('VERIFICATION_PENDING', 'COMPLETED', 'CANCELLED')),
  expiration_date datetime,
     */

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
