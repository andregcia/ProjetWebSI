1. Faire les INSERT avec le fichier projetSI.sql
2. Pour se conecter :
ADMINISTRATEUR : 
- login : demoadmin
- mot de passe : demoadmin

MEMBRE :
- login : demo
- mdp : demo

Ce qui marche pas :
- Lors de la modification d'un cours nous ne pouvons pas insérer une image : renvoie champ null...
- Lorsque l'on regarde un episode : impossible de cliquer sur les boutons modifier, supprimer, 
voir un autre épisode, acheter le cours... 
	--> taper lien direct pour modifier un épisode : [...]modifierEpisode?cE=NUMERO_EPISODE
	--> pour la suppression ça fonctionne mais pas lien existant.
	--> pour voir un nouvel épsode : voirEpisode?cC=NUM_COURS&cvE=NUM_EPISODE