package gestionComptes.Personnel;

import gestionComptes.Clients.mapClients;
import gestionVentes.mapVentes;

public class Manager extends Salarie {
	private static mapSalarie tableSalarie; 
	private static mapVentes tableVente;
	private static mapClients tableClient;
	public Manager(int id, String pseudo,String mdp, String nom, String prenom, String tel, double salaire) {
		super(id,pseudo, mdp, nom, prenom, tel, salaire);
		this.setFct(Fonction.Manager);
		tableSalarie =new mapSalarie();
	}
	
	public static mapSalarie getTableSalarie() {
		return tableSalarie;
	}
	
	public static mapVentes getTableVente() {
		return tableVente;
	}
	
	public static mapClients getTableClient() {
		return tableClient;
	}

	public void embaucher(Salarie s) {
		tableSalarie.addSalarie(s);		
	}

	public void licencier(Salarie s) {
		if(!s.equals(this)){
			tableSalarie.deleteSalarie(s);	
		}
		//le Manager ne peut pas se licencier lui meme		
	}


	public void augmenter(Salarie s, double marge) {		
		tableSalarie.augmenter(s,marge);
	}
	
	
	public void diminuer(Salarie s, double marge) {
		tableSalarie.diminuer(s,marge);
		
	}
	
	public void displayTableSalarie() {
		tableSalarie.display();
	}

	

	
	
	
	
	
}
