package gestionComptes.Menus;

import java.util.Scanner;

import gestionComptes.Clients.Client;
import gestionComptes.Clients.mapClients;
import gestionVehicules.Vehicule;
import gestionVehicules.mapVehiculesAV;

public class menuGeneral extends menus{
	boolean exit;
	boolean retour=false;
	int choixSession=0;//type d'utilisateur client,vendeur,...		
	String pseudo, mdp;
	
	
	
	private void afficheMenu() {
		// TODO Auto-generated method stub		
		System.out.println("\n1.Se connecter ");		
		System.out.println("2.Creer un compte client");
		System.out.println("-1.Quitter");
				
	}
	private void afficheChoixSession() {
		System.out.println("1.Se connecter en tant que Manager");
		System.out.println("2.Se connecter en tant que Vendeur");
		System.out.println("3.Se connecter en tant que Receptionnaire");
		System.out.println("4.Se connecter en tant que Client");
		System.out.println("-1.Retour");
	}
	private void executeActionConnexion(int choixSession) {
		System.out.println("Entrez votre Pseudo :");
		String pseudo=lireChaine();
		System.out.println("Entrez votre mot de passe :");
		String mdp=lireChaine();
		
		switch(choixSession) {
		case -1:
			retour=true;
			break;
		case 1:
			menuManager menuManag =new menuManager(pseudo,mdp);
			if(menuManag.authentification()!= null) {														
					System.out.println("Chargement du menu manager ...");															
					menuManag.executeMenu();								
				}																		
			break;
		case 2:
			menuVendeur menuVend =new menuVendeur(pseudo,mdp);
			if(menuVend.authentification()== true) {											
					System.out.println("Chargement du menu vendeur ...");															
					menuVend.executeMenu();
				}																						
						
			break;
		case 3:
			menuReception menuRecep =new menuReception(pseudo,mdp);
			if(menuRecep.authentification()!=null) {							
				
					System.out.println("Chargement du menu receptionnaire ...");															
					menuRecep.executeMenu();
				}
													
			
			break;
		case 4:
			menuClient menuCli =new menuClient(pseudo,mdp);
			if(menuCli.authentification()!= null) {							
				
					System.out.println("Chargement du menu client ...");															
					menuCli.executeMenu();
				}													
			
			break;
		default:
			System.out.println("Choix erroné");
		}
	}
	private void executeAction(int choix) {
		 switch (choix) {
		 	case -1:
		 		exit=true;
		 		System.out.println("Au revoir !");
		 		break;
		 	case 1: 		 		
		 		while(!retour) {
		 			afficheChoixSession();
		 			choixSession=lireChoix();		 			
					executeActionConnexion(choixSession);
		 		}
		
				break;
			
			//creation d'un compte client
			case 2:
				System.out.println("2.Création d'un compte client :");
				System.out.println("Saisissez votre nom :");
				String nom=lireChaine();
				System.out.println("Saisissez votre prenom :");
				String prenom=lireChaine();
				System.out.println("Saisissez votre numéro de telephone :");
				String tel=lireChaine();
				System.out.println("Definir votre pseudo :");
				String NewPseudo=lireChaine();
				System.out.println("Definir votre mot de passe :");
				String NewMdp=lireChaine();
				if(mapClients.getClient(NewPseudo)==null) {
					mapClients.addClient(new Client(NewPseudo,NewMdp,nom,prenom,tel));
					//enregistrer dans le fichier des clients
					System.out.println("Compte crée avec succés");
				}else {
					System.out.println("Pseudo déja existant");
				}
				retour=false;
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
