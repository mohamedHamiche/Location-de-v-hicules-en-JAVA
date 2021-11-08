package gestionComptes.Personnel;

public class Vendeur extends Salarie {

	private int nbVentes;
	public Vendeur(int id, String mdp, String nom, String prenom, String tel, double salaire) {
		super(id, mdp, nom, prenom, tel,salaire);		
		this.setFct(Fonction.Vendeur);	 
	}
	public int getNbVentes() {
		return nbVentes;
	}
	public void setNbVentes(int nbVentes) {
		this.nbVentes = nbVentes;
	}
	
	
	//afficher liste vehicules a vendre: mapVehiculeAV 
	//afficher liste des Clients: le clients a accées au catalogue mais doit etre sur place pour choisir un vendeur et un vehicule
	//creer un client
	//associer une Vente a un client mapVentes.ajouter 
	//vendre vehicule: VendeurX.vendre(vehicule,client): client.acheterVehicule(v)
	//nbVentes ++
	
	

	
}
