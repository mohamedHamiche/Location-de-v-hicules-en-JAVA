package gestionComptes.Menus;

import gestionComptes.Database;
import gestionComptes.Personnel.Salarie;
import gestionComptes.Personnel.mapSalarie;

public class menuVendeur implements menu{
	
	private static String pseudo,mdp;
	private static boolean connected;	
	public menuVendeur(String pseudo, String mdp) {		
		menuVendeur.pseudo = pseudo;
		menuVendeur.mdp = mdp;
		connected=false;
	}


	public boolean authentification() {			
		Database.getTableSalarie();
		Salarie s=mapSalarie.getSalarie(menuVendeur.pseudo,menuVendeur.mdp);
		if(s!=null) {
					System.out.println("Autentification réussie !");
					System.out.println("Bienvenue "+s.getNom()+" "+s.getPrenom());
					menuVendeur.connected=true;
					return true;
				}else{
					System.out.println("Mot de passe ou Identifiant incorrecte !");
					return false;	
				}			
		}


	public static boolean isConnected() {
		return connected;
	}


	public static void setConnected(boolean connected) {
		menuVendeur.connected = connected;
	}


	@Override
	public void afficheMenu() {
		// TODO Auto-generated method stub
		System.out.println("1.Catalogue");
		System.out.println("2.Mes ventes");
		System.out.println("3.Chercher ventes par vehicule");
		System.out.println("4.Conclure une vente");		
		System.out.println("0.Deconnexion");
	}
	
}
