package gestionComptes.Personnel;

import java.util.ArrayList;
import gestionVentes.*;
import gestionVehicules.*;
import gestionComptes.Database;
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
	
	
	//peut voir liste vehicules a vendre: mapVehiculeAV.display()
	//peut voir liste des Clients: le client a accées au catalogue mais doit etre sur place pour choisir un vendeur et un vehicule
	//creer un client s'il n'existe pas deja
	//pour vendre: creer une fiche de vente pour le client le vehicule concernés  
	//-----------   				et ajouter le vehicule à la liste des vehicule du client
	//nbVentes ++
	
	
	//afficher liste des ventes de ce vendeur:
	//on passe par la methode getVentes pour qu'un vendeur ne puisse acceder qu'a ces ventes a lui
	public void displayVentes() {		
		ArrayList<Vente> r = mapVentes.getVentes(this);
		for(Vente v : r) {
			System.out.println(v.getId()+" "+v.getVehicule().getMarque()+ " "+v.getClient().getNom()+" "+v.getPrixVente());
		}
	}
		
	
	public void vendre(Vehicule v, Client c, double prix, String options) {
		Database.getTableVente();
		Vente vente = new Vente(mapVentes.getNextID(),c,this,v,"dateDuJour",prix,options);
		mapVentes.addVente(vente);
		//c.getListeVehicule().acheter(v);
		this.nbVentes++;
		//supprimer du catalogue
		mapVehiculesAV.deleteVehicule(v);
	}
	

	
}
