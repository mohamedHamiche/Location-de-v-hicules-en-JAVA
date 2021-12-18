package gestionComptes.Menus;

import gestionComptes.Database;
import gestionComptes.Clients.Client;
import gestionComptes.Clients.mapClients;
import gestionEntretiens.mapEntretien;
import gestionVehicules.Vehicule;
import gestionVehicules.mapVehiculesAV;

public class menuClient extends menus {
	
	private static String pseudo,mdp;	
	private static Client cli;
	boolean exit;	
	
	public menuClient(String pseudo, String mdp) {		
		menuClient.pseudo = pseudo;
		menuClient.mdp = mdp;
		cli=authentification();
	}
	
	public Client authentification() {			
		Database.getTableClient();
		Client c=mapClients.getClient(menuClient.pseudo,menuClient.mdp);
		if(c!=null) {
					System.out.println("Autentification réussie !");
					System.out.println("Bienvenue "+c.getNom()+" "+c.getPrenom());
					return c;
				}else{
					System.out.println("Mot de passe ou Identifiant incorrecte !");
					return null;	
				}			
	}
	
	public static Client getCli() {
		return cli;
	}

	private void afficheMenu(){		
		System.out.println("\n----------------------------------");
		System.out.println("1.Voir le catalogue");
		System.out.println("12. Filtrer par marque de vehicule");
		System.out.println("13. Filtrer par type de vehicule");
		System.out.println("2.Mes vehicules");
		System.out.println("3.Ajouter un vehicule");		
		System.out.println("4.Demander entretien");
		System.out.println("5.Voir l'etat de mes demandes");
		System.out.println("-1.Deconnexion");
	}
	
	private Vehicule form_ajout_vehicule() {
		System.out.println("Ajout d'un vehicule client");
		System.out.println("Donnez la marque");
		String marque=lireChaine();
		System.out.println("Donnez le modele");
		String modele=lireChaine();
		Vehicule v=new Vehicule(marque,modele);
		return v;
	}
	
	private void form_demande_entretien() {		
		System.out.println("Entrez l'indice du vehicule:");
		int index=lireChoix();
		System.out.println("Entrez la date souhaité");
		String dateE= lireChaine();
		System.out.println("Entrez une description");
		String description= lireChaine();
		cli.demandeEntretien(index, dateE, description);
	}
	
	private void executeAction(int choix) {		 
		switch (choix) {
		 	case -1:
		 		exit=true;
		 		break;
			case 1:				
				mapVehiculesAV.displayCatalogue();				
				break;	
			case 12:
				String marque = lireChaine();
				mapVehiculesAV.displayCatalogue(marque);			
				break;	
			case 13:				
				System.out.println("Citadine(1), Berline(2), Limousine(3), Break(4), SUV(5), Compacte(6), Coupe(7), Cabriolet(8)");
				int type = lireChoix();
				mapVehiculesAV.displayCatalogue(type);				
				break;	
			case 2:
				cli.afficherMesVehicules();		
				break;	
			case 3:				
				Vehicule v=form_ajout_vehicule();
				cli.addV(v);				
				break;	
			case 4:
				form_demande_entretien();				
				break;
			case 5:
				mapEntretien.displayEtat(cli);				
				break;
			default:
				System.out.println("Choix erroné");
		 }
	}
	
	public void executeMenu() {		
		while(!exit) {
			afficheMenu();
			int choix=lireChoix();
			executeAction(choix);
		}		
	}
}
