/* Define tables for account service. Names of these tables have prefix a_ */

create table a_gamer_account (
  gamer_id bigint not null,
  email char(255) not null,
  user_name char(64) not null,
  user_password char(64) not null,
  account_status char(16) not null check (account_status in ('NEW', 'ACTIVE', 'REMOVED', 'REMOVED_COMPLETELY')),
  registration_date datetime not null,
  registered_from_ip char(64),
  removal_date datetime,
  locale char(16) not null default 'en' check (locale in ('en', 'ru')),
  primary key (gamer_id),
  unique key (email)
) engine=innodb;

create table a_gamer_role (
  gamer_role_id bigint not null auto_increment,
  gamer_id bigint not null,
  role_name char(16) not null check (role_name in ('ROLE_ADMIN', 'ROLE_MODERATOR', 'ROLE_REMOVED_USER')),
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
  operation_status char(32) not null check (operation_status in ('VERIFICATION_PENDING', 'COMPLETED', 'CANCELLED')),
  expiration_date datetime,
  primary key (operation_id)
) engine=innodb;

alter table a_account_operation add constraint foreign key (gamer_id) references a_gamer_account (gamer_id);

create table a_profile (
  gamer_id bigint not null,
  sex char(1) check (sex in ('M', 'W')),
  country char(255),
  state_province char(255),
  city char(255),
  birthday date,
  about text(4000),
  avatar_url char(255),
  detected_country char(255),
  detected_state_province char(255),
  detected_city char(255),
  primary key (gamer_id)
) engine=innodb;

alter table a_profile add constraint foreign key (gamer_id) references a_gamer_account (gamer_id);

create table a_friends (
  gamer_id bigint not null,
  friend_id bigint not null,
  friendship_status char(32) not null check (friendship_status in ('REQUESTED', 'ACCEPTED')),
  requested_date datetime,
  accepted_date datetime,
  primary key (gamer_id, friend_id)
) engine=innodb;

alter table a_friends add constraint foreign key (gamer_id) references a_gamer_account (gamer_id);
alter table a_friends add constraint foreign key (friend_id) references a_gamer_account (gamer_id);

create table a_user_session_log (
  session_id bigint not null auto_increment,
  gamer_id bigint not null,
  ip_address char(16) not null,
  start_time datetime not null,
  end_time datetime,
  primary key (session_id)
) engine=innodb;

alter table a_user_session_log add constraint foreign key (gamer_id) references a_gamer_account (gamer_id);
