/* Define tables for account service. Names of these tables have prefix a_ */

create table a_gamer_account (
  gamer_id bigint not null,
  email char(255) not null,
  user_name char(64) not null,
  password char(64) not null,
  status char(3) not null check (status in ('NEW', 'ACT', 'RMD', 'RCY')),
  registration_date datetime not null,
  removal_date datetime,
  locale char(16) not null default 'en' check (locale in ('en', 'ru')),
  primary key (gamer_id),
  unique key (email)
) engine=innodb;
