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
	
	
	
	
	
	
}
