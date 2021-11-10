package gestionComptes.Personnel;

public class Receptionnaire extends Salarie {

	public Receptionnaire(String pseudo, String mdp, String nom, String prenom, String tel, double salaire) {
		super(pseudo, mdp, nom, prenom, tel, salaire);
		this.setFct(Fonction.Receptionnaire);
	}
	//hashMap<key,ficheEntrerien> 
	//liste tehniciens mapSalarie.i.fct='Technicien'
	
	//affecterVehiculeTechnicien  selon dispo(minimale): ficheE.technicien=t
	//t.listVaREP.ajouter 
	//quand t.repare : receptionnaire.ficheE.entretienValide(); deja fait dans technicien
	//si client recupere ficheE.Sortie
	
	
}
