DROP TABLE IF EXISTS game;


CREATE TABLE IF NOT EXISTS game (
    id varchar(40) primary key,
    p00 varchar(2),
    p01 varchar(2),
    p02 varchar(2),
    p10 varchar(2),
    p11 varchar(2),
    p12 varchar(2),
    p20 varchar(2),
    p21 varchar(2),
    p22 varchar(2)
)