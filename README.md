# TurboDZ
Application Java pour la gestion d'une concession automobile

Comment ca marche ?
Au lancement de l'application, la page de bienvenue vous propose de vous connecter ou de créer un compte si vous etes un nouveau client.

1.se connecter en tant que :
    Manager pour gerer les salaries et les vehicules du catalogue.
    Vendeur pour conclure une vente d'un vehicule avec un client.
    Receptionnaire pour gérer le service apres vente( entretiens des vehicules).
    Technicien pour prendre en charge les entretiens affectés.
    Client pour voir le catalogue chercher par filtres, ajouter un vehicule et en demander un entretiens, suivre l'etat de mes entretiens.

-----Exemple de scénario:  -----

Client:
    J'ai déja un compte client (client1,mdp) je me connecte   
    Je demande un entretien pour un de mes vehicules.(si je l'ai acheté ailleurs je peux l'ajouter à ma liste)
    Je peux suivre l'état de ce service (entretien) à tout moment, pour l'instant il est en cours.

Technicien:
    Je me connecte, le nombre d'entretiens que je dois effectuer est affiché.
    Je peux aussi afficher la liste.
    Une fois un vehicule réparé, je le marque comme Termine.

Client: 
    L'etat de mon entretien est Termine, je vais récupperer mon vehicule.

Receptionnaire:
    Le client s'est presenté, je lui remet son vehicule, l'etat de l'entretien est marqué Remis,le tarif et la date de      sortie sont précisés.

    Client: 
    Je veux acheter un vehicule du catalogue, je vais en concession je choisis mon vehicule et le vendeur.

Vendeur:
    Je me connecte, le nombre de mes ventes est affiché, bientot un de plus !
    Conclure une vente, je remplis la fiche de vente, le vehicule est supprimé du catalogue, il est maintenat dans la liste des véhicules de ce gentil client.
    Et mon nombre de ventes à augmenté (employé du mois hihi).

Manager:
    Il y a un vendeur qui n'est pas très efficace, je vais le licecier, et embaucher un autre à sa place. 
    Il y a trop de charge de travail à l'atelier, je vais ajouter des techniciens.
    Un nouveau vehicule, je l'inscris dans le catalogue.


L'application est assez interractive, on peut revenir en arrière dans les menus se deconnecter et changer de session facilement sans quitter le programme.
A éviter: pour indiquer un chiffre réel utiliser la virgule au lieu du point.

Identifiants et mdp des utilisateurs déja dans la base :
Manager : manager / mdp
Vendeurs: vendeur1 / mdp
Technicien: tech1 / mdp
Receptionnaire: recep / mdp
Clients: client1 / mdp  - client2 / mdp



