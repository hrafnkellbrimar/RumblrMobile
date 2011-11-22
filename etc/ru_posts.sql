create table ru_posts
(
  id int Identity (1, 1) primary key NOT NULL,
  date datetime,
  type varchar(64),
  username varchar(64) not null
)