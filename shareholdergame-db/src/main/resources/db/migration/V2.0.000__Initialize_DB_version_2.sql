/* Define tables for account service. Names of these tables have prefix a_ */

create table a_gamer_account (
  gamer_id bigint not null,
  email char(255) not null,
  user_name char(64) not null,
  user_password char(64) not null,
  account_status char(16) not null check (account_status in ('NEW', 'ACTIVE', 'REMOVED', 'REMOVED_COMPLETELY')),
  registration_date datetime not null,
  removal_date datetime,
  locale char(16) not null default 'en' check (locale in ('en', 'ru')),
  primary key (gamer_id),
  unique key (email)
) engine=innodb;

create table a_gamer_role (
  gamer_role_id bigint not null auto_increment,
  gamer_id bigint not null,
  role_name char(16) not null check (role_name in ('ROLE_ADMIN', 'ROLE_MODERATOR')),
  primary key (gamer_role_id),
  unique key (gamer_id, role_name)
) engine=innodb;

create table a_account_operation (
  operation_id bigint not null auto_increment,
  gamer_id bigint not null,
  operation_type char(16) not null check (operation_type in ('CHANGE_STATUS', 'CHANGE_USERNAME', 'CHANGE_EMAIL', 'CHANGE_PASSWORD')),
  old_value char(255),
  new_value char(255),
  verification_code char(64),
  initiation_date datetime not null,
  completion_date datetime,
  operation_status char(16) not null check (operation_status in ('VERIFICATION_PENDING', 'COMPLETED', 'CANCELLED')),
  expiration_date datetime,
  primary key (operation_id)
) engine=innodb;
