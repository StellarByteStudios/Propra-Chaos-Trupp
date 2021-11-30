-- Erstmal ein paar Aufgaben in 2 Listen eintragen

insert into ListEntity (DisplayName, ListeIDForegin)
values ('Das muss ich noch machen', 1),
       ('Das muss ich nicht mehr machen', 1),
       ('Spülen', 1),
       ('Waschen', 1),
       ('Webserver aufbauen', 1),
       ('Zimmer Aufräumen', 1),
       ('Korrektur fertig machen', 1),
       ('Meinen Traum leben', 1),
       ('All das muss ich machen', 3),
       ('Computer aufbauen', 3),
       ('Etwas trinken', 3),
       ('Stargate fertig schauen', 3),
       ('Die Top 4 besiegen', 3),
       ('Ein Brot schmieren', 3);


-- Jetzt wurden auch schon ein paar erledigt

update ListEntity
set Done = true
where DisplayName = 'Das muss ich nicht mehr machen' or
      DisplayName = 'Spülen' or
      DisplayName = 'Waschen' or
      DisplayName = 'Zimmer Aufräumen' or
      DisplayName = 'Korrektur fertig machen' or
      DisplayName = 'Computer aufbauen' or
      DisplayName = 'Etwas trinken';