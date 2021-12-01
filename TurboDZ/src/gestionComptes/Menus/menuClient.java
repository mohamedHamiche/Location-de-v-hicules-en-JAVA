package gestionComptes.Menus;


import gestionComptes.Database;
import gestionComptes.Clients.Client;
import gestionComptes.Clients.mapClients;

public class menuClient implements menu {
	
	private static String pseudo,mdp;	
	
	public menuClient(String pseudo, String mdp) {		
		menuClient.pseudo = pseudo;
		menuClient.mdp = mdp;
	}
	
	public Client autentification() {			
		Database.getTableClient();
		Client c=mapClients.getClient(menuClient.pseudo,menuClient.mdp);
		if(c!=null) {
					System.out.println("Autentification réussie !");
					System.out.println("Bienvenue "+c.getNom()+" "+c.getPrenom());
					return c;
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
