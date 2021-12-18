package gestionComptes.Menus;



import gestionComptes.Database;
import gestionComptes.Clients.mapClients;
import gestionComptes.Personnel.Fonction;
import gestionComptes.Personnel.Manager;
import gestionComptes.Personnel.Salarie;
import gestionComptes.Personnel.Technicien;
import gestionComptes.Personnel.Vendeur;
import gestionComptes.Personnel.mapSalarie;
import gestionVehicules.TypeV;
import gestionVehicules.Vehicule;
import gestionVehicules.mapVehiculesAV;

public class menuManager extends menus {

	private static String pseudo,mdp;
	boolean exit=false;
	public menuManager(String pseudo, String mdp) {		
		menuManager.pseudo = pseudo;
		menuManager.mdp = mdp;		
	}


	public Manager authentification() {			
		Database.getTableSalarie();
		Salarie s=mapSalarie.getSalarie(menuManager.pseudo,menuManager.mdp);
		if(s!=null && s.getFct()==Fonction.Manager) {
					System.out.println("Autentification réussie !");
					System.out.println("Bienvenue "+s.getNom()+" "+s.getPrenom());
					return mapSalarie.getManager(s.getId());					
				}else{
					System.out.println("Mot de passe ou Identifiant incorrecte !");
					return null;	
				}			
		}


	
	
	private void afficheMenu() {
		System.out.println("\n----------------------------------");
		System.out.println("1.Liste des salaries");
		System.out.println("2.Liste des clients");
		System.out.println("3.Liste des vehicules-catalogue");
		System.out.println("4.Ajouter un vendeur");//embaucher		
		System.out.println("5.Ajouter un technicien");		
		System.out.println("6.Supprimer un salarié");//licencier
		System.out.println("7.Ajouter un vehicule");
		
		System.out.println("-1.Deconnexion");
			
	}
	
	private Vendeur form_ajout_vendeur() {
		System.out.println("Ajout d'un vendeur");
		System.out.println("Donnez le nom");
		String nom=lireChaine();
		System.out.println("Donnez le prenom");
		String prenom=lireChaine();
		System.out.println("Donnez le pseudo");
		String pseudo=lireChaine();
		System.out.println("Donnez le mdp");
		String mdp=lireChaine();
		System.out.println("Donnez le tel");
		String tel=lireChaine();
		System.out.println("Donnez le salaire");
		float salaire=lireFloat();
		Vendeur v = new Vendeur(pseudo,mdp,nom,prenom,tel,salaire);
		return v;
	}
	private Technicien form_ajout_technicien() {
		System.out.println("Ajout d'un technicien");
		System.out.println("Donnez le nom");
		String nom=lireChaine();
		System.out.println("Donnez le prenom");
		String prenom=lireChaine();
		System.out.println("Donnez le pseudo");
		String pseudo=lireChaine();
		System.out.println("Donnez le mdp");
		String mdp=lireChaine();
		System.out.println("Donnez le tel");
		String tel=lireChaine();
		System.out.println("Donnez le salaire");
		float salaire=lireFloat();
		Technicien t = new Technicien(pseudo,mdp,nom,prenom,tel,salaire);
		return t;
	}
	private Vehicule form_ajout_vehicule() {
		System.out.println("Ajout d'un vehicule client");
		System.out.println("Donnez la marque");
		String marque=lireChaine();
		System.out.println("Donnez le modele");
		String modele=lireChaine();
		System.out.println("Citadine(1), Berline(2), Limousine(3), Break(4), SUV(5), Compacte(6), Coupe(7), Cabriolet(8)");
		int i = lireChoix();
		TypeV type = TypeV.Berline; //par defaut à regler plus tard
		System.out.println("Donnez le prix");
		float prixBase = lireFloat();
		Vehicule v=new Vehicule(marque,modele,type,prixBase);
		return v;
	}
	private void executeAction(int choix) {
		 switch (choix) {
		 	case -1:
		 		exit=true;
		 		break;
			case 1:				
				mapSalarie.display();				
				break;	
			case 2:
				mapClients.display();	
				break;	
			case 3:				
				mapVehiculesAV.displayCatalogue();				
				break;	
			case 4:				
				Salarie s=(Salarie)form_ajout_vendeur();
				mapSalarie.addSalarie(s);
				//inscrire dans le fichier
				break;	
			case 5:				
				Salarie s1=(Salarie)form_ajout_technicien();
				mapSalarie.addSalarie(s1);
				//inscrire dans le fichier
				break;	
			case 6:
				System.out.println("Donnez l'id du salarie à supprimer");
				int key = lireChoix(); 
				mapSalarie.deleteSalarie(key);
				break;
			case 7:				
				Vehicule v=form_ajout_vehicule();
				mapVehiculesAV.addVehicule(v);
				//inscrire dans le fichier
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
