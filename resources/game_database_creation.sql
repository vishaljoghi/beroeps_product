DROP DATABASE IF EXISTS game;
CREATE DATABASE game;
USE game;

CREATE TABLE players (
	id_players INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(25) NOT NULL UNIQUE,
	birthdate DATE NOT NULL,
	password VARCHAR(20) NOT NULL,
	PRIMARY KEY (id_players)
);

CREATE TABLE scoreboard (
	id_score INT NOT NULL AUTO_INCREMENT,
    id_players INT NOT NULL,
    time DATETIME NOT NULL,
    score INT NOT NULL,
    PRIMARY KEY (id_score),
    FOREIGN KEY (id_players) REFERENCES players(id_players)
);

INSERT INTO players (username, birthdate, password) 
	VALUES ('MoW2003', '2003-05-07', 'password'),
		   ('DEADP00L', '2003-01-01', 'password'),
           ('CrazyBull', '0000-00-00', 'password'),
           ('Knuckles', '0000-00-00', 'password'),
           ('Fisheye', '0000-00-00', 'password'),
           ('Dooming', '0000-00-00', 'password'),
           ('Raptor', '0000-00-00', 'password'),
           ('Superboy', '0000-00-00', 'password'),
           ('Mad Dog', '0000-00-00', 'password'),
           ('Blonde', '0000-00-00', 'password'),
           ('user', '0000-00-00', 'user');
           
INSERT INTO scoreboard (id_players, time, score)
	VALUES (1, '2022-03-08 16:47:04', 20),
		   (2, '2022-03-12 00:16:45', 18),
           (3, '2022-02-24 19:31:47', 4),
           (4, '2022-05-11 19:57:07', 16),
           (5, '2022-05-03 04:39:52', 4),
           (6, '2022-03-03 12:17:18', 10),
           (7, '2022-03-30 07:48:20', 12),
           (8, '2022-04-25 05:07:25', 2),
           (9, '2022-05-25 17:15:04', 8),
           (10, '2022-03-18 09:10:16', 16);
		   