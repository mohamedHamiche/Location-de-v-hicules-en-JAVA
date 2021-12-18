package gestionComptes.Personnel;

import gestionComptes.Personne;


public abstract class Salarie extends Personne{
	private Fonction fct;
	private double salaire;
	
	
	public Salarie(String pseudo, String mdp, String nom, String prenom, String tel, double salaire) {		
		super( mapSalarie.getNextID(), pseudo ,mdp, nom, prenom, tel);		
		this.salaire=salaire;
		mapSalarie.getTableSalarie().put(this.getId(), this);
	}
	//cas de mise à jour d'un salarie on connait deja l'id
	public Salarie(int id,String pseudo, String mdp, String nom, String prenom, String tel, double salaire) {		
		super( id, pseudo ,mdp, nom, prenom, tel);		
		this.salaire=salaire;		
	}
	
	public Fonction getFct() {
		return fct;
	}
	public void setFct(Fonction fct) {
		this.fct = fct;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	
	
	
}
