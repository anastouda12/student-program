/**
Si Spring trouve un fichier data.sql à la base du dossier des
ressources, il l’exécute au démarrage. Idéal pour remplir les tables en phase de développement.
*/

INSERT INTO  Users (username,password,enabled) VALUES ('anas','{bcrypt}$2a$10$P9.gyx5196NUPT9Oliiyp.rhMfGNBE8milAHkWIavvTFSpIhhXgnK',true);
INSERT INTO Authorities (username, authority) VALUES ('anas', 'ROLE_ADMIN');

INSERT INTO  Course (id,libe,ects) VALUES ('INT1', 'Introductions','10');
INSERT INTO  Course (id,libe,ects) VALUES ('MAT1', 'Mathématique','3');
INSERT INTO  Course (id,libe,ects) VALUES ('CAI1', 'Anglais I','2');
INSERT INTO  Course (id,libe,ects) VALUES ('DEV1', 'Développement I','10');
INSERT INTO  Course (id,libe,ects) VALUES ('DEV2', 'Développement II','10');
INSERT INTO  Course (id,libe,ects) VALUES ('WEBG2', 'Développement web I','5');
INSERT INTO  Course (id,libe,ects) VALUES ('SYS2', 'Système d''exploitation I','5');
INSERT INTO  Course (id,libe,ects) VALUES ('DON2', 'Persistance de donnée I','5');
INSERT INTO  Course (id,libe,ects) VALUES ('CAI2', 'Anglais II','2');
INSERT INTO  Course (id,libe,ects) VALUES ('STAT2', 'Statistique','3');


INSERT INTO  Student (id,name,firstname,gender,section) VALUES (43256, 'Touda Lachiri', 'Anas','Homme','GESTION');
INSERT INTO  Student (id,name,firstname,gender,section) VALUES (45003, 'Sponge', 'Bob','Homme','RESEAU');
INSERT INTO  Student (id,name,firstname,gender,section) VALUES (49577, 'Star', 'Patrick','Homme','INDUSTRIEL');
INSERT INTO  Student (id,name,firstname,gender,section) VALUES (48536, 'Bulbe', 'Bulbizar','Homme','GESTION');




INSERT INTO  Program (courseId,studentId,created_date,updated_date) VALUES ('DEV1', 43256,now(),now());
INSERT INTO  Program (courseId,studentId,created_date,updated_date) VALUES ('DEV2', 43256,now(),now());
INSERT INTO  Program (courseId,studentId,created_date,updated_date) VALUES ('DEV1', 45003,now(),now());









