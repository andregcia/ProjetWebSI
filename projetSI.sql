drop index AVOIRVU2_FK;
drop index AVOIRVU_FK;
drop index AVOIRVU_PK;
drop table AVOIRVU;
drop index COURS_PK;
drop table COURS;
drop index SE_COMPOSE_FK;
drop index EPISODE_PK;
drop table EPISODE;
drop index POSSEDE2_FK;
drop index POSSEDE_FK;
drop index POSSEDE_PK;
drop table POSSEDE;
drop index USER_PK;
drop table "USER";

create table "USER" (
ID                   INTEGER                        not null
GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
FIRSTNAME            VARCHAR(30),
LASTNAME             VARCHAR(30)                    not null,
EMAIL                VARCHAR(40)                    not null,
USERNAME             VARCHAR(30)		    not null,
PASSWORD             VARCHAR(100)                   not null,
SCAN                 INTEGER                        not null,
primary key (ID)
);

create table COURS (
IDCOURS              INTEGER                        not null
GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1), 
TITLECOURS           VARCHAR(30)                    not null,
DESCRIPTION          VARCHAR(200),
PICTURE              VARCHAR(20),
PRICE                INTEGER                        not null,
primary key (IDCOURS)
);

create table EPISODE (
IDEPISODE            INTEGER                        not null
GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1), 
IDCOURS              INTEGER                        not null,
TITLEEPISODE         VARCHAR(30)                    not null,
URL                  VARCHAR(100)                   not null,
primary key (IDEPISODE),
foreign key (IDCOURS)
      references COURS (IDCOURS)
);

create table AVOIRVU (
ID                   INTEGER                        not null,
IDEPISODE            INTEGER                        not null,
"DATE"               DATE                           not null,
primary key (ID, IDEPISODE),
foreign key (ID)
      references "USER" (ID),
foreign key (IDEPISODE)
      references EPISODE (IDEPISODE)
);

create unique index AVOIRVU_PK on AVOIRVU (
ID ASC,
IDEPISODE ASC
);

create  index AVOIRVU_FK on AVOIRVU (
ID ASC
);

create  index AVOIRVU2_FK on AVOIRVU (
IDEPISODE ASC
);

create unique index COURS_PK on COURS (
IDCOURS ASC
);

create unique index EPISODE_PK on EPISODE (
IDEPISODE ASC
);

create  index SE_COMPOSE_FK on EPISODE (
IDCOURS ASC
);

create table POSSEDE (
ID                   INTEGER                        not null,
IDCOURS              INTEGER                        not null,
primary key (ID, IDCOURS),
foreign key (ID)
      references "USER" (ID),
foreign key (IDCOURS)
      references COURS (IDCOURS)
);

create unique index POSSEDE_PK on POSSEDE (
ID ASC,
IDCOURS ASC
);

create  index POSSEDE_FK on POSSEDE (
ID ASC
);

create  index POSSEDE2_FK on POSSEDE (
IDCOURS ASC
);

create unique index USER_PK on "USER" (
ID ASC
);
INSERT INTO "USER" (FIRSTNAME, LASTNAME, EMAIL, USERNAME, PASSWORD, SCAN) VALUES ('Andre', 'Garcia', 'andregcia@gmail.com', 'andregcia', 'f955f62dab66faeec663bf873962ece8c3b817d2f52e9ff88a688bf7a4e5fc16', 1);
INSERT INTO "USER" (FIRSTNAME, LASTNAME, EMAIL, USERNAME, PASSWORD, SCAN) VALUES ('Julie', 'Helin', 'juliehelin@gmail.com', 'julie', '41028769c98b981922099851253edb9d97bd275acb124fb3d1d5c76a87ad08e2', 0);

INSERT INTO "COURS" (TITLECOURS, DESCRIPTION, PICTURE, PRICE) VALUES ('Java EE', 'Blalalalalajfufjhdsfuyf', 'javaee.jpg', 10);
INSERT INTO "COURS" (TITLECOURS, DESCRIPTION, PICTURE, PRICE) VALUES ('Securite', 'Blalalalalajfufjhdsfuyf', 'secu.jpg', 15);
INSERT INTO "COURS" (TITLECOURS, DESCRIPTION, PICTURE, PRICE) VALUES ('Gestion de portefeuille', 'Blalalalalajfufjhdsfuyf', 'gestionport.jpg', 0);

INSERT INTO "EPISODE" (IDCOURS,TITLEEPISODE,URL) VALUES (1,'Introduction','http://youtu.be/R0dogNWjqw8?list=PLHqN89yRGMyAcwWcSWk59_S_-BQVn3Rrb');
INSERT INTO "EPISODE" (IDCOURS,TITLEEPISODE,URL) VALUES (1,'JPA','');
INSERT INTO "EPISODE" (IDCOURS,TITLEEPISODE,URL) VALUES (1,'JSF','');
INSERT INTO "EPISODE" (IDCOURS,TITLEEPISODE,URL) VALUES (1,'EJB','');
INSERT INTO "EPISODE" (IDCOURS,TITLEEPISODE,URL) VALUES (1,'CDI','');
INSERT INTO "EPISODE" (IDCOURS,TITLEEPISODE,URL) VALUES (1,'Services REST','');
INSERT INTO "EPISODE" (IDCOURS,TITLEEPISODE,URL) VALUES (2,'Introduction','');
INSERT INTO "EPISODE" (IDCOURS,TITLEEPISODE,URL) VALUES (2,'Contrôle d'accès','');
INSERT INTO "EPISODE" (IDCOURS,TITLEEPISODE,URL) VALUES (2,'Authentification','');
INSERT INTO "EPISODE" (IDCOURS,TITLEEPISODE,URL) VALUES (2,'Politique de sécurité du SI','');
INSERT INTO "EPISODE" (IDCOURS,TITLEEPISODE,URL) VALUES (3,'Introduction','');
INSERT INTO "EPISODE" (IDCOURS,TITLEEPISODE,URL) VALUES (4,'Gestion des actions','');
INSERT INTO "EPISODE" (IDCOURS,TITLEEPISODE,URL) VALUES (5,'Exercices','');