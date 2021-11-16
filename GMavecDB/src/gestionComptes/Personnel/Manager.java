package gestionComptes.Personnel;

import gestionComptes.Database;


public class Manager extends Salarie {
	
	//on devra appliquer par la suite le design pattern singleton sur cette classe
	//
	//le manager est un salarie (heritage) peut embaucher licencier augmenter le salaire ou le diminuer
	
	public Manager(int id, String pseudo,String mdp, String nom, String prenom, String tel, double salaire) {
		super(id,pseudo, mdp, nom, prenom, tel, salaire);
		this.setFct(Fonction.Manager);				
	}
	
	

	public void embaucher(Salarie s) {	
		Database.getTableSalarie().addSalarie(s);;
	}

	public void licencier(Salarie s) {
		if(!s.equals(this)){
			Database.getTableSalarie().deleteSalarie(s);	
		}
		//le Manager ne peut pas se licencier lui meme		
	}


	public void augmenter(Salarie s, double marge) {		
		Database.getTableSalarie().augmenter(s,marge);
	}
	
	
	public void diminuer(Salarie s, double marge) {
		Database.getTableSalarie().diminuer(s,marge);
		
	}
	
	
	
}
