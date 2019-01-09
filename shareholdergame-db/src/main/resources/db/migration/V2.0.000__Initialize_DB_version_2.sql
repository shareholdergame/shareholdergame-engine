/* Define tables for account service. Names of these tables have prefix a_ */

create table a_account_status (
  status_id tinyint not null,
  description char(255) not null,
  primary key (status_id),
  unique key (description)
) engine=innodb;

create table a_gamer_account (
  gamer_id bigint not null,
  email char(255) not null,
  user_name char(64) not null,
  password char(64) not null,
  status_id tinyint not null,
  registration_date datetime not null,
  removal_date datetime,
  locale_id char(16) not null default 'en',
  subtopic_name char(64) not null,
  primary key (gamer_id),
  unique key (email)
) engine=innodb;

alter table a_gamer_account add constraint foreign key (status_id) references a_account_status (status_id);
