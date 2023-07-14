DROP TABLE IF EXISTS MEMBER;

CREATE TABLE MEMBER(
  member_id bigint primary key auto_increment,
  email varchar(100) not null,
  password varchar(100) not null,
  name varchar(50) not null
);
