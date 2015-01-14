usage des branches
-----

-master
branche principale
sur cette branche, on merge les versions du projet de la branche develop qui sont fonctionnelles
(ex: v1 -> premier sprint constitué par exemple du modèle, etc, v6 -> version avec interface grapique, blablabla) 
avant de push/merge sur cette branche, on se met d'accord, pas de manipulation de cette branche sans voir avec tout le monde plz


-develop
branche sur laquelle on push/merge UNIQUEMENT du code fonctionnel
pas d'erreurs, warnings, bugs
on tag les commits qui représentent des versions fonctionnelles


-branche personnelle
essayez au maximum de vous créer en plus de ces 2 branches, une branche personnelle de travail
vous ne mergez que du 100% fonctionnel
vous pouvez bien sur créer des branches supplémentaires 

-----

-personne ne supprime de branches, sauf sa/ses branche(s) personnelle(s)
-on fonctionne avec maven, le pom.xml en est le fichier de config. Maven -> gestionnaire de dépendances. ex: junit, etc. lisez un tuto sur maven pour plus d'infos
-peu importe l'IDE (eclipse, net beans, whatever ..)
-essayez au maximum d'utiliser des libraries existantes et évoluées, pour éviter de coder des trucs déjà existants
-ça peut parraitre bête, mais vérifiez que vous avez java 7
