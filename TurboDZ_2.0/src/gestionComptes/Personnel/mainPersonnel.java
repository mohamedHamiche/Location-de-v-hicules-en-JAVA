package gestionComptes.Personnel;

import java.util.Scanner;

import gestionComptes.Database;
import gestionComptes.Clients.Client;
import gestionComptes.Clients.mapClients;
import gestionComptes.Menus.menuClient;
import gestionComptes.Menus.menuGeneral;
import gestionComptes.Menus.menuManager;
import gestionComptes.Menus.menuReception;
import gestionComptes.Menus.menuVendeur;

//la classe main devra etre renommée et déplacée dans un autre package 
public class mainPersonnel {
	
	/*//methode a deplacer dans une autre classe mais laquelle ?
	public static boolean autentificationSalarie(String pseudo, String mdp) {			
		Database.getTableSalarie();
		Salarie s=mapSalarie.getSalarie(pseudo,mdp);
		if(s!=null) {
					System.out.println("Autentification réussie !");
					System.out.println("Bienvenue "+s.getNom()+" "+s.getPrenom());
					return true;
				}else{
					System.out.println("Mot de passe ou Identifiant incorrecte !");
					return false;	
				}			
		}
	
	public static boolean autentificationClient(String pseudo, String mdp) {			
		Database.getTableClient();
		Client c=mapClients.getClient(pseudo,mdp);
		if(c!=null) {
					System.out.println("Autentification réussie !");
					System.out.println("Bienvenue "+c.getNom()+" "+c.getPrenom());
					return true;
				}else{
					System.out.println("Mot de passe ou Identifiant incorrecte !");
					return false;	
				}			
		}
	//a deplacer aussi
	 
	 */
	public static String lireChaine() {
		String chaine=null;
			Scanner sai_chaine = new Scanner(System.in);
			chaine = sai_chaine.next();
		
		return chaine;
	}
	

	public static void main(String[] args) {
		Database db = new Database();		
		Manager leBoss = new Manager(4,"managerNumber1","mdp","MR directeur","prenom1","0005848", 8000);
		//on remarque que l'id du manager est ecrit manuellement et non pas generés auto. (on appliquera singleton par la suite)
		Database.getTableSalarie();
		
		//recuperer le salarie d'indice 1 dans la map
		Salarie s = mapSalarie.getSalarie(1);
		
		Database.getTableSalarie().display();
		
		//augmenter son salaire de 300 euros
		System.out.println("\nApres augmentation :");
		leBoss.augmenter(s, 300);
		Database.getTableSalarie().display();
		
		menuGeneral menuG = new menuGeneral();
		menuG.executeMenu();
		
		
		
			/**/
	}

}
