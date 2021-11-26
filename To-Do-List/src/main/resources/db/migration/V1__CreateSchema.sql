-- Ist noch was da? alles weg damit
drop table if exists ListEntity;
drop table if exists ToDoList;
drop table if exists User;

-- Usertabelle erzeugen
-- Speichert nur die Daten des Users selbst
-- To-Do-Liste referenziert später auf User via Foregin Key
create table User
(
    UserID   int auto_increment,
    Username varchar(100) not null,
    constraint User_UserID_uindex
        unique (UserID)
);

alter table User
    add primary key (UserID);

-- ToDoList Tabelle erzeugen
-- Speichert nur den Link zwischen dem User (eigener Foregin Key) und den Listeneinträgen (deren Foregin Key)
-- Eventuell wird noch eingebaut, das ein User mehrere Listen haben kann
create table ToDoList
(
    ListID        int auto_increment,
    UserIDForegin int null,
    constraint ToDoList_ListID_uindex
        unique (ListID),
    constraint ToDoList_User_UserID_fk
        foreign key (UserIDForegin) references User (UserID)
);

alter table ToDoList
    add primary key (ListID);

-- Listeneintag Tabelle erzeugen
-- Speichert die Daten zu einem Task, welcher zu erledigen ist
-- Gehört immer zu genau einer Liste
create table ListEntity
(
    ListEntityID   int auto_increment,
    DisplayName    varchar(200) default 'nächste Aufgabe' not null,
    Done           tinyint(1)   default 0                 null,
    ListeIDForegin int                                    null,
    constraint ListEntity_ListEntityID_uindex
        unique (ListEntityID),
    constraint ListEntity_ToDoList_ListID_fk
        foreign key (ListeIDForegin) references ToDoList (ListID)
);

alter table ListEntity
    add primary key (ListEntityID);
