1. Faire les INSERT avec le fichier projetSI.sql
2. Pour se conecter :
ADMINISTRATEUR : 
- login : demoadmin
- mot de passe : demoadmin

MEMBRE :
- login : demo
- mdp : demo

Ce qui marche pas :
- Lors de la modification d'un cours nous ne pouvons pas ins�rer une image : renvoie champ null...
- Lorsque l'on regarde un episode : impossible de cliquer sur les boutons modifier, supprimer, 
voir un autre �pisode, acheter le cours... 
	--> taper lien direct pour modifier un �pisode : [...]modifierEpisode?cE=NUMERO_EPISODE
	--> pour la suppression �a fonctionne mais pas lien existant.
	--> pour voir un nouvel �psode : voirEpisode?cC=NUM_COURS&cvE=NUM_EPISODE