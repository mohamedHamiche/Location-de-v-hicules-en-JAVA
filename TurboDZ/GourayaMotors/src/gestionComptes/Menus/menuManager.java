package gestionComptes.Menus;

import gestionComptes.Database;
import gestionComptes.Personnel.Manager;
import gestionComptes.Personnel.Salarie;
import gestionComptes.Personnel.mapSalarie;

public class menuManager implements menu {

	private static String pseudo,mdp;
	public menuManager(String pseudo, String mdp) {		
		menuManager.pseudo = pseudo;
		menuManager.mdp = mdp;		
	}


	public Manager authentification() {			
		Database.getTableSalarie();
		Salarie s=mapSalarie.getSalarie(menuManager.pseudo,menuManager.mdp);
		if(s!=null) {
					System.out.println("Autentification réussie !");
					System.out.println("Bienvenue "+s.getNom()+" "+s.getPrenom());
					return mapSalarie.getManager(s.getId());					
				}else{
					System.out.println("Mot de passe ou Identifiant incorrecte !");
					return null;	
				}			
		}


	@Override
	public void afficheMenu() {
		System.out.println("1.Liste des salaries");
		System.out.println("2.Liste des clients");
		System.out.println("3.Liste des vehicules-catalogue");
		System.out.println("4.Ajouter un salarié");//embaucher
		System.out.println("41.Augmenter un salaire");
		System.out.println("42.Diminuer un salaire");
		System.out.println("4.Supprimer un salarié");//licencier
		System.out.println("5.Ajouter un vehicule");
		
	}
	
	
}
