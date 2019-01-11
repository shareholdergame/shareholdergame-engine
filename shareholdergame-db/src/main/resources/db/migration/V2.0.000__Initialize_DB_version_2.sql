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
