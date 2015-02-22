INSERT INTO "MEMBER" (ID,FIRSTNAME, LASTNAME, EMAIL, USERNAME, PASSWORD, SCAN) VALUES (1,'Jean', 'Superadmin', 'admin@admin.fr', 'demoadmin', '53016290e37b085a2feebeded49ce3b78f7a737ede2ff8c27a3787cfe7eaebf5', 1);
INSERT INTO "MEMBER" (ID,FIRSTNAME, LASTNAME, EMAIL, USERNAME, PASSWORD, SCAN) VALUES (2,'Paul', 'Demo', 'demo@demo.fr', 'demo', '2a97516c354b68848cdbd8f54a226a0a55b21ed138e207ad6c5cbb9c00aa5aea', 0);

INSERT INTO "COURS" (IDCOURS,TITLE, DESCRIPTION, PICTURE, PRICE) VALUES (1,'Java EE', 'Java Enterprise Edition, est une spécification pour la technique Java d Oracle plus particulièrement destinée aux applications d’entreprise.', '1.png', 10);
INSERT INTO "COURS" (IDCOURS,TITLE, DESCRIPTION, PICTURE, PRICE) VALUES (2,'Securite', 'La sécurité informatique est l'ensemble des moyens techniques, organisationnels, juridiques et humains nécessaires et mis en place pour conserver, rétablir, et garantir la sécurité des systèmes informatiques.', '2.png', 15);
INSERT INTO "COURS" (IDCOURS,TITLE, DESCRIPTION, PICTURE, PRICE) VALUES (3,'Gestion de portefeuille', 'Gestion des fonds de placement d'un investisseur ou d'une institution, en vue d'en optimiser la valorisation, en effectuant des placements opportuns dans le cadre d'une stratégie politiques d'investissements déterminée au préalable.', '3.jpg', 0);

INSERT INTO "EPISODE" (IDEPISODE,COURS_IDCOURS,TITLE,URL) VALUES (1,1,'Introduction','https://www.youtube.com/watch?v=R0dogNWjqw8');
INSERT INTO "EPISODE" (IDEPISODE,COURS_IDCOURS,TITLE,URL) VALUES (2,1,'JPA','https://www.youtube.com/watch?v=R0dogNWjqw8');
INSERT INTO "EPISODE" (IDEPISODE,COURS_IDCOURS,TITLE,URL) VALUES (3,1,'JSF','https://www.youtube.com/watch?v=R0dogNWjqw8');
INSERT INTO "EPISODE" (IDEPISODE,COURS_IDCOURS,TITLE,URL) VALUES (4,1,'EJB','https://www.youtube.com/watch?v=R0dogNWjqw8');
INSERT INTO "EPISODE" (IDEPISODE,COURS_IDCOURS,TITLE,URL) VALUES (5,1,'CDI','https://www.youtube.com/watch?v=R0dogNWjqw8');
INSERT INTO "EPISODE" (IDEPISODE,COURS_IDCOURS,TITLE,URL) VALUES (6,1,'Services REST','https://www.youtube.com/watch?v=R0dogNWjqw8');
INSERT INTO "EPISODE" (IDEPISODE,COURS_IDCOURS,TITLE,URL) VALUES (7,2,'Introduction','https://www.youtube.com/watch?v=R0dogNWjqw8');
INSERT INTO "EPISODE" (IDEPISODE,COURS_IDCOURS,TITLE,URL) VALUES (8,2,'Contrôle d accès','https://www.youtube.com/watch?v=R0dogNWjqw8');
INSERT INTO "EPISODE" (IDEPISODE,COURS_IDCOURS,TITLE,URL) VALUES (9,2,'Authentification','https://www.youtube.com/watch?v=R0dogNWjqw8');
INSERT INTO "EPISODE" (IDEPISODE,COURS_IDCOURS,TITLE,URL) VALUES (10,2,'Politique de sécurité du SI','https://www.youtube.com/watch?v=R0dogNWjqw8');
INSERT INTO "EPISODE" (IDEPISODE,COURS_IDCOURS,TITLE,URL) VALUES (11,3,'Introduction','https://www.youtube.com/watch?v=R0dogNWjqw8');
INSERT INTO "EPISODE" (IDEPISODE,COURS_IDCOURS,TITLE,URL) VALUES (12,3,'Gestion des actions','https://www.youtube.com/watch?v=R0dogNWjqw8');
INSERT INTO "EPISODE" (IDEPISODE,COURS_IDCOURS,TITLE,URL) VALUES (13,3,'Exercices','https://www.youtube.com/watch?v=R0dogNWjqw8');

INSERT INTO "MEMBER_COURS" (LISTCOURS_IDCOURS,LISTUSER_ID) VALUES (1,1);
INSERT INTO "MEMBER_COURS" (LISTCOURS_IDCOURS,LISTUSER_ID) VALUES (2,1);