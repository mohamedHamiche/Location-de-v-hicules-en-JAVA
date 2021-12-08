package gestionComptes.Menus;


import java.util.Scanner;

import gestionComptes.Database;
import gestionComptes.Clients.Client;
import gestionComptes.Clients.mapClients;
import gestionEntretiens.Etat;
import gestionVehicules.mapVehiculesAV;

public class menuClient implements menu {
	
	private static String pseudo,mdp;	
	private static Client cli;
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
	public static String lireChaine() {
		String chaine=null;
			Scanner sai_chaine = new Scanner(System.in);
			chaine = sai_chaine.next();
		
		return chaine;
	}
	public static int lireChoix() {
		int choix=0;
		Scanner sai_choix = new Scanner(System.in);
		choix = sai_choix.nextInt();
		
		return choix;
	}
	
	@Override
	public void afficheMenu() {
		// TODO Auto-generated method stub		
		System.out.println("1.Voir le catalogue");
		System.out.println("12.		Filtrer par marque de vehicule");
		System.out.println("13.		Filtrer par type de vehicule");
		System.out.println("2.Mes vehicules");
		System.out.println("3.Ajouter un vehicule");		
		System.out.println("4.Demander entretien");
		System.out.println("-1.Deconnexion");
		int choix=lireChoix();
		 switch (choix) {
			case 1:				
				mapVehiculesAV.displayCatalogue();				
			break;	
			case 12:
				String marque = lireChaine();
				mapVehiculesAV.displayCatalogue(marque);			
			break;	
			case 13:
				String type = lireChaine();
				mapVehiculesAV.displayCatalogue(type);				
			break;	
			case 2:
				cli.afficherMesVehicules();		
			break;	
			case 3:
				System.out.println("3.Ajouter un vehicule");
				cli.addV();		
			break;	
			case 4:
				System.out.println("4.Demander entretien");
				System.out.println("Entrez l'indice du vehicule:");
				int index=lireChoix();
				System.out.println("Entrez la date souhaité");
				String dateE= lireChaine();
				System.out.println("Entrez une description");
				String description= lireChaine();
				cli.demandeEntretien(index, dateE, description);
			break;	
		 }
		
	}
	
}
