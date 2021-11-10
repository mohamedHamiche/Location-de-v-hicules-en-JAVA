package gestionComptes.Personnel;

import java.util.ArrayList;
import gestionVentes.*;
import gestionVehicules.*;
import gestionComptes.Clients.*;
public class Vendeur extends Salarie {

	private int nbVentes;
	public Vendeur(String pseudo, String mdp, String nom, String prenom, String tel, double salaire) {
		super(pseudo, mdp, nom, prenom, tel,salaire);		
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
	
	
	//afficher liste des ventes:
	public void displayVentes() {
		ArrayList<Vente> r = DirecteurImp.getTableVente().getVentes(this);
		for(Vente v : r) {
			System.out.println(v.getId()+" "+v.getVehicule().getMarque()+ " "+v.getClient().getNom()+" "+v.getPrixVente());
		}
	}
	
	public void vendre(Vehicule v, Client c, double prix, String options) {
		Vente vente = new Vente(c,this,v,"dateDuJour",prix,options);
		DirecteurImp.getTableVente().addVente(vente);
		//c.getListeVehicule().acheter(v);
		this.nbVentes++;
	}
	

	
}
