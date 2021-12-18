package gestionComptes.Menus;

import gestionComptes.Database;
import gestionComptes.Clients.mapClients;
import gestionComptes.Personnel.Fonction;
import gestionComptes.Personnel.Salarie;
import gestionComptes.Personnel.Technicien;
import gestionComptes.Personnel.Vendeur;
import gestionComptes.Personnel.mapSalarie;
import gestionEntretiens.Entretien;
import gestionEntretiens.Etat;
import gestionEntretiens.mapEntretien;
import gestionVehicules.mapVehiculesAV;
import gestionVentes.Vente;
import gestionVentes.mapVentes;

public class menuTechnicien extends menus{
	private static String pseudo,mdp;
	private static Technicien tech;
	boolean exit;
	
	public menuTechnicien(String pseudo, String mdp) {		
		menuTechnicien.pseudo = pseudo;
		menuTechnicien.mdp = mdp;	
		tech = authentification();		
	}
	
	public Technicien authentification() {			
		Database.getTableSalarie();
		Salarie s=mapSalarie.getSalarie(menuTechnicien.pseudo,menuTechnicien.mdp);
		if(s!=null && s.getFct()==Fonction.Technicien) {
					System.out.println("Autentification réussie !");
					System.out.println("Bienvenue "+s.getNom()+" "+s.getPrenom());	
					System.out.println("Vous avez "+((Technicien)s).getListeE().size()+" entretiens en cours");
					return (Technicien)s;
				}else{
					System.out.println("Mot de passe ou Identifiant incorrecte !");
					return null;	
				}			
		}
	
	private void afficheMenu() {
		System.out.println("\n--------------------------------------");
		System.out.println("1.Mes Entretiens en cours");		
		System.out.println("2.Terminer un entretien");
		System.out.println("-1.Deconnexion");
	}
	
	private void executeAction(int choix) {
		 switch (choix) {
		 	case -1:
		 		exit=true;
		 		break;			
			case 1:				
				tech.displayEntretiens();			
				break;				
			case 2:				
				System.out.println("Donnez l'id de la fiche à finaliser ?");
				int key = lireChoix()-1;//-1 car l'indice de la liste commence a 0 et 1 à l'affichage
				if(tech.getListeE().get(key)!=null && key>=0) {
					Entretien newEnt = tech.getListeE().get(key);	
					System.out.println("Rediger un rapport ou remarques :");
					String rapport = lireChaine();												
					newEnt.setRapport(rapport);
					
					newEnt.setEtat(Etat.Termine);	//changer l'etat en termine
					mapEntretien.updateEntretien(newEnt);	//mise à jour dans la base				
					tech.supprimerEntretien(key);	//supression de la liste de ce technicien
				}else {System.out.println("erreur: l'index de l'entretien n'existe pas dans cette liste");}
				
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

	public static Technicien getTech() {
		return tech;
	}
}
