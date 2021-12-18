package gestionComptes.Menus;

import gestionComptes.Database;
import gestionComptes.Clients.Client;
import gestionComptes.Clients.mapClients;
import gestionComptes.Personnel.Fonction;
import gestionComptes.Personnel.Salarie;
import gestionComptes.Personnel.Vendeur;
import gestionComptes.Personnel.mapSalarie;
import gestionVehicules.Vehicule;
import gestionVehicules.mapVehiculesAV;
import gestionVentes.Vente;
import gestionVentes.mapVentes;

public class menuVendeur extends  menus{
	
	private static String pseudo,mdp;
	private static Vendeur vend;
	boolean exit;
	
	public menuVendeur(String pseudo, String mdp) {		
		menuVendeur.pseudo = pseudo;
		menuVendeur.mdp = mdp;	
		vend = authentification();
	}


	public Vendeur authentification() {			
		Database.getTableSalarie();
		Salarie s=mapSalarie.getSalarie(menuVendeur.pseudo,menuVendeur.mdp);
		if(s!=null && s.getFct()==Fonction.Vendeur) {
					System.out.println("Autentification réussie !");
					System.out.println("Bienvenue "+s.getNom()+" "+s.getPrenom());		
					System.out.println("Nombre de ventes : "+((Vendeur)s).getNbVentes());
					return (Vendeur)s;
				}else{
					System.out.println("Mot de passe ou Identifiant incorrecte !");
					return null;	
				}			
		}




	private void afficheMenu() {
		System.out.println("\n--------------------------------------");
		System.out.println("1.Catalogue");
		System.out.println("2.Clients");
		System.out.println("3.Mes ventes");
		System.out.println("4.Chercher ventes par marque de vehicule");
		System.out.println("5.Conclure une vente");		
		System.out.println("-1.Deconnexion");
	}
	private Vente form_ajout_vente() {
		System.out.println("Remplir la fiche de vente");
		
		System.out.println("Donnez l'id du client");
		int idC=lireChoix();
		Client client = mapClients.getClient(idC);
		if(client==null) {
			System.out.println("id du client introuvable");
			exit=true;
		}
		
		System.out.println("Donnez l'id du vehicule");
		int idV=lireChoix();
		Vehicule vehicule = mapVehiculesAV.getVehicule(idV);
		if(vehicule==null) {
			System.out.println("id du vehicule introuvable");
			exit=true;
		}
		System.out.println("Donnez la date");
		String dateVente = lireChaine();
		System.out.println("Donnez le prix de vente");
		float prixVente=lireFloat();
		System.out.println("Des options supplémentaires ?");
		String options = lireChaine();
		
		Vente v=new Vente(client,vend,vehicule,dateVente,prixVente,options);
		System.out.println("nouvelle vente instanciée");
		//On l'ajoute a la liste des vehicules possédés par le client
		client.addV(vehicule);
		//on le supprime du catalogue
		mapVehiculesAV.deleteVehicule(idV);
		return v;
	}
	public static Vendeur getVend() {
		return vend;
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
				mapClients.display();
				break;
			case 3:				
				mapVentes.displayVentes(vend);
				break;	
			case 4:				
				System.out.println("Quelle marque voulez vous chercher ?");
				String marque=lireChaine();
				mapVentes.displayVentes(marque);
				break;	
			case 5:
				Vente vente =form_ajout_vente();
				//insertion dans la map
				mapVentes.addVente(vente);	
				//incémenter le nombre de ventes							
				mapSalarie.updateNbVentes(vend.getId());
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
