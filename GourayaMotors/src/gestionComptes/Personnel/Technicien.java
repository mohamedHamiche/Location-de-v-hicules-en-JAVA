package gestionComptes.Personnel;

public class Technicien extends Salarie {

	public Technicien(int id, String mdp, String nom, String prenom, String tel, double salaire) {
		super(id, mdp, nom, prenom, tel, salaire);
		this.setFct(Fonction.Technicien);
	}
	//liste des vehicules a reparer
	//reparer vehicule: v.etat=pret
	//supprimer vehicule
	//getDispo : length(listevArep)
	
}
