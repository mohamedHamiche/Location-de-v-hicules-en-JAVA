package gestionComptes.Clients;

import gestionComptes.Personne;

public class Client extends Personne{

	public Client(String pseudo, String mdp, String nom, String prenom, String tel) {
		super(mapClients.getNextID(),pseudo, mdp, nom, prenom, tel);
		
	}
	//peut voir le catalogue liste de vehicules a vendre
	//peut voir la liste de ses achats: vehicules achetes, mapVentes pour le client x
	//a une liste de ses vehicules
	//peut demander un entretien pour un de ses vehicules
	
}
 