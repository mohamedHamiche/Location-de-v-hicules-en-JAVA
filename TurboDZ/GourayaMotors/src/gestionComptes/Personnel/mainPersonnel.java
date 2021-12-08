package gestionComptes.Personnel;

import java.util.Scanner;

import gestionComptes.Database;
import gestionComptes.Clients.Client;
import gestionComptes.Clients.mapClients;
import gestionComptes.Menus.menuClient;
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
		
		
		
		
		int choix=0; //se connecter ou creer un compte
		int choixSession=0;//type d'utilisateur client,vendeur,...		
		String pseudo, mdp;
		System.out.println("\n1.Se connecter ");		
		System.out.println("2.Creer un compte client");
		
		Scanner sai_choix = new Scanner(System.in);
			 choix = sai_choix.nextInt();
		
		switch (choix) {
			case 1: 
				System.out.println("1.Se connecter en tant que Manager");
				System.out.println("2.Se connecter en tant que Vendeur");
				System.out.println("3.Se connecter en tant que Receptionnaire");
				System.out.println("4.Se connecter en tant que Client");
					Scanner sai_choixSession = new Scanner(System.in);
					choixSession = sai_choixSession.nextInt();
				
				System.out.println("Entrez votre Pseudo :");
				pseudo=lireChaine();
				System.out.println("Entrez votre mot de passe :");
				mdp=lireChaine();
				switch(choixSession) {
					case 1:
						menuManager menuManag =new menuManager(pseudo,mdp);
						if(menuManag.authentification()!= null) {														
								System.out.println("Chargement du menu manager ...");															
								menuManag.afficheMenu();								
							}
																					
						break;
					case 2:
						menuVendeur menuVend =new menuVendeur(pseudo,mdp);
						if(menuVend.authentification()== true) {							
							
								System.out.println("Chargement du menu vendeur ...");															
								menuVend.afficheMenu();
							}																						
							
					
						break;
					case 3:
						menuReception menuRecep =new menuReception(pseudo,mdp);
						if(menuRecep.authentification()!=null) {							
							
								System.out.println("Chargement du menu receptionnaire ...");															
								menuRecep.afficheMenu();
							}
																
						
						break;
					case 4:
						menuClient menuCli =new menuClient(pseudo,mdp);
						if(menuCli.authentification()!= null) {							
							
								System.out.println("Chargement du menu client ...");															
								menuCli.afficheMenu();
							}
																
						
						break;
				}
				break;
			//creation d'un compte client
			case 2:
				System.out.println("2.Création d'un compte client :");
				System.out.println("Saisissez votre nom :");
				String nom=lireChaine();
				System.out.println("Saisissez votre prenom :");
				String prenom=lireChaine();
				System.out.println("Saisissez votre numéro de telephone :");
				String tel=lireChaine();
				System.out.println("Definir votre pseudo :");
				String NewPseudo=lireChaine();
				System.out.println("Definir votre mot de passe :");
				String NewMdp=lireChaine();
				if(mapClients.getClient(NewPseudo)==null) {
					mapClients.addClient(new Client(NewPseudo,NewMdp,nom,prenom,tel));
					//enregistrer dans le fichier des clients
					System.out.println("Compte crée avec succés");
				}else {
					System.out.println("Pseudo déja existant");
				}
				break;
						
				
		}
			/**/
	}

}
