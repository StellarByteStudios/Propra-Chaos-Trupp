create table if not EXISTS Kraechz
(
    id int auto_increment primary key,
    handle varchar(140) unique not null,
    text varchar(140) unique not null
);

