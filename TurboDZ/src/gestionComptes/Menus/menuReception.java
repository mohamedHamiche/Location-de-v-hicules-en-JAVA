package gestionComptes.Menus;

import java.util.Scanner;

import gestionComptes.Database;
import gestionComptes.Personnel.Receptionnaire;
import gestionComptes.Personnel.Salarie;
import gestionComptes.Personnel.mapSalarie;
import gestionEntretiens.Etat;

public class menuReception implements menu{
	private static String pseudo,mdp;			
	private static Receptionnaire recep;
	public menuReception(String pseudo, String mdp) {		
		menuReception.pseudo = pseudo;
		menuReception.mdp = mdp;			
		recep=autentification();
	}


	public Receptionnaire autentification() {			
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


	@Override
	public void afficheMenu() {
		// TODO Auto-generated method stub
		System.out.println("    Fiches d'entretiens");
		System.out.println("1.Entretiens en cours");		
		System.out.println("2.Entretiens terminés (en attente du client)");
		System.out.println("3.Entretiens finalisés (vehicule remis au client)");		
		System.out.println("	4.Liste techniciens");
		System.out.println("-1.Deconnexion");
		int choix;
		Scanner sai_choix = new Scanner(System.in);
		 choix = sai_choix.nextInt();
		 switch (choix) {
			case 1:
				recep.afficherEntretiens(Etat.EnCours);				
			break;	
			case 2:
				recep.afficherEntretiens(Etat.Termine);				
			break;	
			case 3:
				recep.afficherEntretiens(Etat.Remis);				
			break;	
			case 4:
				//mapSalarie.afficherTechniciens();				
			break;	
		 }
	}
	
	
}
