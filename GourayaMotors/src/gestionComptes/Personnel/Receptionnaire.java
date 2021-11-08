package gestionComptes.Personnel;

public class Receptionnaire extends Salarie {

	public Receptionnaire(int id, String mdp, String nom, String prenom, String tel, double salaire) {
		super(id, mdp, nom, prenom, tel, salaire);
		this.setFct(Fonction.Receptionnaire);
	}
	//hashMap<key,ficheEntrerien> 
	//liste tehniciens mapSalarie.i.fct='Technicien'
	
	//affecterVehiculeTechnicien  selon dispo: ficheE.technicien=t
	//t.listVaREP.ajouter 
	//quand t.repare : receptionnaire.ficheE.entretienValide();
	//si client recupere ficheE.Sortie
	
	
}
