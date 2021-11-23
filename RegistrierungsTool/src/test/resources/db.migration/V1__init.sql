drop table if exists Student;

create table Student
(
    gitHubName varchar(200) not null,
    name varchar(200) not null,
    matrikelnr int not null,
    unikennung varchar(200) not null,

    constraint Student_pk
    primary key(gitHubName)
)