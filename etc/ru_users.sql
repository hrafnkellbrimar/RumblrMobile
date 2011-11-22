CREATE TABLE ru_users
(
  id int Identity (1, 1) primary key NOT NULL,
  name varchar(128),
  username varchar(128) unique,
  password varchar(128),
  email varchar(256)
)
