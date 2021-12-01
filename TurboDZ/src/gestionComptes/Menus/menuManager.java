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


	public Manager autentification() {			
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
		// TODO Auto-generated method stub
		
	}
	
	
}
