package gestionComptes.Menus;


import gestionComptes.Database;
import gestionComptes.Personnel.Fonction;
import gestionComptes.Personnel.Receptionnaire;
import gestionComptes.Personnel.Salarie;
import gestionComptes.Personnel.mapSalarie;
import gestionEntretiens.Entretien;
import gestionEntretiens.Etat;
import gestionEntretiens.mapEntretien;

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
		
		if(s!=null && s.getFct()==Fonction.Receptionnaire) {
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
	private void form_maj_entretien(int key) {
		//on indique le tarif la date de sortie 
		Entretien oldE = mapEntretien.getEntretien(key);
		if(oldE!=null) {
			Entretien newE = new Entretien(oldE);
			System.out.println("Donnez le tarif du service");
			float tarif = lireFloat();
			System.out.println("Donnez la date de sortie");
			String dateS= lireChaine();				
			newE.setDateS(dateS);
			newE.setTarif(tarif);	
			
			//sans oublier de changer l'etat à remis
			newE.setEtat(Etat.Remis);
			mapEntretien.updateEntretien(newE);
		}else
		{System.out.println("Erreur form_maj_entretien : entretien introuvable");	}
		
	}
	public static Receptionnaire getRecep() {
		return recep;
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
			case 4:
				//on met à jour la fiche d'entretien correspondante
				System.out.println("Donnez l'id de la fiche d'entretien");
				int key = lireChoix();
				form_maj_entretien(key);				
				break;
		
			default:
				System.out.println("Choix erroné");
									
		 }
	}
	public void afficheMenu() {		
		System.out.println("\n-------------------------------------------");
		System.out.println("1.Entretiens en cours");		
		System.out.println("2.Entretiens terminés (en attente du client)");
		System.out.println("3.Entretiens finalisés (vehicule remis au client)");
		//4.lorque le client vient recuperer son vehicule
		System.out.println("4.Finaliser une fiche d'entretien (remise au client)");
		System.out.println("-1.Deconnexion");
				 
	}
	
	
}
