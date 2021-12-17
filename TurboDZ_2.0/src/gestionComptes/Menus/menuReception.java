package gestionComptes.Menus;

import java.util.Scanner;

import gestionComptes.Database;
import gestionComptes.Clients.Client;
import gestionComptes.Clients.mapClients;
import gestionComptes.Personnel.Receptionnaire;
import gestionComptes.Personnel.Salarie;
import gestionComptes.Personnel.mapSalarie;
import gestionEntretiens.Etat;

public class menuReception extends menus{
	private static String pseudo,mdp;			
	private static Receptionnaire recep;
	
	boolean exit;
	public menuReception(String pseudo, String mdp) {		
		menuReception.pseudo = pseudo;
		menuReception.mdp = mdp;			
		recep=authentification();
	}


	public Receptionnaire authentification() {			
		Database.getTableSalarie();
		Salarie s=mapSalarie.getSalarie(menuReception.pseudo,menuReception.mdp);
		
		if(s!=null) {
					System.out.println("Autentification réussie !");
					System.out.println("Bienvenue "+s.getNom()+" "+s.getPrenom());									
					return mapSalarie.getReceptionnaire(s.getId());
				}else{
					System.out.println("Mot de passe ou Identifiant incorrecte !");
					return null;	
				}			
		}


	public void executeMenu() {		
		while(!exit) {
			afficheMenu();
			int choix=lireChoix();
			executeAction(choix);						
		
		}		
	}
	
	private void executeAction(int choix) {		
		 switch (choix) {
		 	case -1:
		 		exit=true;			 		
		 		break;
		 	case 1:
		 		recep.afficherEntretiens(Etat.EnCours);				
				break;	
			case 2:
				recep.afficherEntretiens(Etat.Termine);				
				break;	
			case 3:
				recep.afficherEntretiens(Etat.Remis);				
				break;	
			
		
			default:
				System.out.println("Choix erroné");
									
		 }
	}
	public void afficheMenu() {		
		System.out.println("1.Entretiens en cours");		
		System.out.println("2.Entretiens terminés (en attente du client)");
		System.out.println("3.Entretiens finalisés (vehicule remis au client)");				
		System.out.println("-1.Deconnexion");
				 
	}
	
	
}
