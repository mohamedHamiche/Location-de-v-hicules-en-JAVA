package gestionComptes.Personnel;

import gestionVehicules.Vehicule;
import gestionVehicules.mapVehiculesAV;


public class Manager extends Salarie {
	
	//on devra appliquer par la suite le design pattern singleton sur cette classe
	//
	//le manager est un salarie (heritage) peut embaucher licencier augmenter le salaire ou le diminuer
	//ajouter supprimer des vehicules du catalogue
	public Manager(int id, String pseudo,String mdp, String nom, String prenom, String tel, double salaire) {
		super(id,pseudo, mdp, nom, prenom, tel, salaire);
		this.setFct(Fonction.Manager);				
	}
	
	
	//GESTION SALARIEES
	public void embaucher(Salarie s) {	
		mapSalarie.addSalarie(s);
	}

	public void licencier(Salarie s) {
		if(!s.equals(this)){
			mapSalarie.deleteSalarie(s);	
		}
		//le Manager ne peut pas se licencier lui meme		
	}

	public void augmenter(Salarie s, double marge) {		
		mapSalarie.augmenter(s,marge);
	}
	
	public void diminuer(Salarie s, double marge) {
		mapSalarie.diminuer(s,marge);
		
	}
	
	//GESTION CATALOGUE
	public void ajouterVehicule(Vehicule v) {			
		mapVehiculesAV.addVehicule(v);		
	}
		//static pour que le vendeur puisse y acceder
	public static void supprimerVehicule(Vehicule v) {
		mapVehiculesAV.deleteVehicule(v);
	}
	
	//modifier prix vehicule
	
	
}
