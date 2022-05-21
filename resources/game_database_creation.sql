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
-- Dummy data for testing

/*	insert into players (username, birthdate, password) values ('shamments0', '2000-11-28', 'pIYDD7sio');
	insert into players (username, birthdate, password) values ('kstangroom1', '2000-09-24', 'h9U9o6');
	insert into players (username, birthdate, password) values ('jberthome2', '2001-06-12', '5f5luT');
	insert into players (username, birthdate, password) values ('bbradbrook3', '2002-03-18', 'rOcMJT8Pyan');
	insert into players (username, birthdate, password) values ('wpolson4', '2003-07-15', 'ZRCb15OumJHq');
	insert into players (username, birthdate, password) values ('dsinnock5', '2001-09-27', 'S8S6WwHBi');
	insert into players (username, birthdate, password) values ('stinkler6', '2000-09-05', 'bS3woXO');
	insert into players (username, birthdate, password) values ('dcorderoy7', '2001-03-17', 'QDMGgHo');
	insert into players (username, birthdate, password) values ('zsamwell8', '2002-07-05', '2ZFhYKn8H4A9');
	insert into players (username, birthdate, password) values ('gbreffitt9', '2000-01-22', 'wamiQKNE8h');

	insert into scoreboard (id_players, time, score) values (7, '2021-02-12 09:03:09', 21);
	insert into scoreboard (id_players, time, score) values (9, '2021-09-30 20:10:41', 16);
	insert into scoreboard (id_players, time, score) values (1, '2021-03-02 05:46:20', 18);
	insert into scoreboard (id_players, time, score) values (3, '2021-06-11 16:22:29', 11);
	insert into scoreboard (id_players, time, score) values (10, '2021-12-25 22:14:46', 15);
	insert into scoreboard (id_players, time, score) values (4, '2021-11-14 07:37:55', 11);
	insert into scoreboard (id_players, time, score) values (9, '2021-06-09 19:26:11', 20);
	insert into scoreboard (id_players, time, score) values (7, '2022-01-03 07:48:28', 18);
	insert into scoreboard (id_players, time, score) values (7, '2021-01-23 20:34:32', 17);
	insert into scoreboard (id_players, time, score) values (3, '2021-04-10 11:47:29', 18);	*/
    
    
    