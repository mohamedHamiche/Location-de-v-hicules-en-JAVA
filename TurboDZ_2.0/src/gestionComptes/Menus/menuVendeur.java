package gestionComptes.Menus;

import gestionComptes.Database;
import gestionComptes.Clients.mapClients;
import gestionComptes.Personnel.Salarie;
import gestionComptes.Personnel.mapSalarie;
import gestionVehicules.Vehicule;
import gestionVehicules.mapVehiculesAV;
import gestionVentes.mapVentes;

public class menuVendeur extends  menus{
	
	private static String pseudo,mdp;
	boolean exit;
	
	public menuVendeur(String pseudo, String mdp) {		
		menuVendeur.pseudo = pseudo;
		menuVendeur.mdp = mdp;		
	}


	public boolean authentification() {			
		Database.getTableSalarie();
		Salarie s=mapSalarie.getSalarie(menuVendeur.pseudo,menuVendeur.mdp);
		if(s!=null) {
					System.out.println("Autentification réussie !");
					System.out.println("Bienvenue "+s.getNom()+" "+s.getPrenom());					
					return true;
				}else{
					System.out.println("Mot de passe ou Identifiant incorrecte !");
					return false;	
				}			
		}




	private void afficheMenu() {
		// TODO Auto-generated method stub
		System.out.println("1.Catalogue");
		System.out.println("2.Mes ventes");
		System.out.println("3.Chercher ventes par vehicule");
		System.out.println("4.Conclure une vente");		
		System.out.println("-1.Deconnexion");
	}
	private void executeAction(int choix) {
		 switch (choix) {
		 	case -1:
		 		exit=true;
		 		break;			
			case 1:				
				mapVehiculesAV.displayCatalogue();				
				break;	
			case 2:				
				mapVentes.displayVentes(vendeur);
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
