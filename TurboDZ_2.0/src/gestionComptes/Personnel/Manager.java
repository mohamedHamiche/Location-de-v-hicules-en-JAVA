package gestionComptes.Personnel;


public class Manager extends Salarie {
	
	public Manager(int id, String pseudo,String mdp, String nom, String prenom, String tel, double salaire) {
		super(id,pseudo, mdp, nom, prenom, tel, salaire);
		this.setFct(Fonction.Manager);				
	}
	
	
}
