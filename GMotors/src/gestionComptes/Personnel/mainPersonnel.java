package gestionComptes.Personnel;

import java.util.Scanner;

import gestionComptes.Personne;
import gestionComptes.Session;
import gestionComptes.Clients.Client;
import gestionComptes.Clients.mapClients;

public class mainPersonnel {
	
	public static boolean autentificationSalarie(String pseudo, String mdp) {			
		Manager.getTableSalarie();
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
		Manager.getTableClient();
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
	
	public static String lireChaine() {
		String chaine=null;
			Scanner sai_chaine = new Scanner(System.in);
			chaine = sai_chaine.next();
		
		return chaine;
	}
	

	public static void main(String[] args) {
		
		Manager d = new Manager(4,"managerNumber1","mdp","MR directeur","prenom1","0005848", 8000);
		
		d.getTableSalarie();
		Salarie s = mapSalarie.getSalarie(1);
		
		d.getTableSalarie().display();
		d.augmenter(s, 300);
		d.getTableSalarie().display();
		
		
		//-------dans le vrai main
		
		int choix=0;
		int choixSession=0;
		String pseudo, mdp;
		System.out.println("1.Se connecter ");		
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
						if(autentificationClient(pseudo,mdp)) {
							
						}
						break;
					case 2:
						if(autentificationSalarie(pseudo,mdp)) {
							System.out.println("Chargement du menu vendeur ...");
						}	
						break;
					case 3:
						if(autentificationSalarie(pseudo,mdp)) {
							System.out.println("Chargement du menu Receptionnaire ...");
						}
						break;
					case 4:
						if(autentificationSalarie(pseudo,mdp)) {
							System.out.println("Chargement du menu Client ...");
						}	
						break;
				}
				break;
			
						
				
		}
			/**/
	}

}
