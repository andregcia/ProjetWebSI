INSERT INTO "MEMBER" (ID,FIRSTNAME, LASTNAME, EMAIL, USERNAME, PASSWORD, SCAN) VALUES (1,'Andre', 'Garcia', 'andregcia@gmail.com', 'andregcia', 'f955f62dab66faeec663bf873962ece8c3b817d2f52e9ff88a688bf7a4e5fc16', 1);
INSERT INTO "MEMBER" (ID,FIRSTNAME, LASTNAME, EMAIL, USERNAME, PASSWORD, SCAN) VALUES (2,'Julie', 'Helin', 'juliehelin@gmail.com', 'julie', '41028769c98b981922099851253edb9d97bd275acb124fb3d1d5c76a87ad08e2', 0);

INSERT INTO "COURS" (IDCOURS,TITLE, DESCRIPTION, PICTURE, PRICE) VALUES (1,'Java EE', 'Blalalalalajfufjhdsfuyf', 'javaee.jpg', 10);
INSERT INTO "COURS" (IDCOURS,TITLE, DESCRIPTION, PICTURE, PRICE) VALUES (2,'Securite', 'Blalalalalajfufjhdsfuyf', 'secu.jpg', 15);
INSERT INTO "COURS" (IDCOURS,TITLE, DESCRIPTION, PICTURE, PRICE) VALUES (3,'Gestion de portefeuille', 'Blalalalalajfufjhdsfuyf', 'gestionport.jpg', 0);

INSERT INTO "EPISODE" (IDEPISODE,COURS_IDCOURS,TITLE,URL) VALUES (1,1,'Introduction','http://youtu.be/R0dogNWjqw8?list=PLHqN89yRGMyAcwWcSWk59_S_-BQVn3Rrb');
INSERT INTO "EPISODE" (IDEPISODE,COURS_IDCOURS,TITLE,URL) VALUES (2,1,'JPA','');
INSERT INTO "EPISODE" (IDEPISODE,COURS_IDCOURS,TITLE,URL) VALUES (3,1,'JSF','');
INSERT INTO "EPISODE" (IDEPISODE,COURS_IDCOURS,TITLE,URL) VALUES (4,1,'EJB','');
INSERT INTO "EPISODE" (IDEPISODE,COURS_IDCOURS,TITLE,URL) VALUES (5,1,'CDI','');
INSERT INTO "EPISODE" (IDEPISODE,COURS_IDCOURS,TITLE,URL) VALUES (6,1,'Services REST','');
INSERT INTO "EPISODE" (IDEPISODE,COURS_IDCOURS,TITLE,URL) VALUES (7,2,'Introduction','');
INSERT INTO "EPISODE" (IDEPISODE,COURS_IDCOURS,TITLE,URL) VALUES (8,2,'Contr�le d acc�s','');
INSERT INTO "EPISODE" (IDEPISODE,COURS_IDCOURS,TITLE,URL) VALUES (9,2,'Authentification','');
INSERT INTO "EPISODE" (IDEPISODE,COURS_IDCOURS,TITLE,URL) VALUES (10,2,'Politique de s�curit� du SI','');
INSERT INTO "EPISODE" (IDEPISODE,COURS_IDCOURS,TITLE,URL) VALUES (11,3,'Introduction','');
INSERT INTO "EPISODE" (IDEPISODE,COURS_IDCOURS,TITLE,URL) VALUES (12,4,'Gestion des actions','');
INSERT INTO "EPISODE" (IDEPISODE,COURS_IDCOURS,TITLE,URL) VALUES (13,5,'Exercices','');