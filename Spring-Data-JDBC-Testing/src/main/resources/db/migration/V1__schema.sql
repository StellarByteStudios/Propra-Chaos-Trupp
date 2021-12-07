drop table if exists Adress;
drop table if exists Benutzer;

create table Benutzer (
    id integer auto_increment,
    vorname varchar(30),
    nachname varchar(40),
    Primary Key (id)
);

create table Adress (
    id integer auto_increment,
    User integer,
    adress_line varchar(100),
    primary key (id),
    constraint Adress_Benutzer_fk
        foreign key (User) references Benutzer (id)
);