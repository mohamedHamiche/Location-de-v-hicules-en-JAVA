package gestionComptes.Personnel;

public class Vendeur extends Salarie {

	private int nbVentes;
	public Vendeur(String pseudo, String mdp, String nom, String prenom, String tel, double salaire) {
		super(pseudo, mdp, nom, prenom, tel,salaire);		
		this.setFct(Fonction.Vendeur);	 
	}
	public Vendeur(int id,String pseudo, String mdp, String nom, String prenom, String tel, double salaire) {
		super(id,pseudo, mdp, nom, prenom, tel,salaire);		
		this.setFct(Fonction.Vendeur);	 
	}
	public int getNbVentes() {
		return nbVentes;
	}
	public void setNbVentes(int nbVentes) {
		this.nbVentes = nbVentes;
	}
	
	public void incrementerNbVentes() {
		this.nbVentes+=1;
	}
	
	
}
