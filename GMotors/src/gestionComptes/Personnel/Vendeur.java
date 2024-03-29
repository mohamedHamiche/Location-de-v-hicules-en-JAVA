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
	
	
	//peut voir liste vehicules a vendre: mapVehiculeAV 
	//peut voir liste des Clients: le client a acc�es au catalogue mais doit etre sur place pour choisir un vendeur et un vehicule
	//creer un client s'il n'existe pas deja
	//pour vendre: creer une fiche de vente pour le client le vehicule concern�s  
	//-----------   				et ajouter le vehicule � la liste des vehicule du client
	//nbVentes ++
	
	
	//afficher liste des ventes de ce vendeur:
	public void displayVentes() {
		ArrayList<Vente> r = Manager.getTableVente().getVentes(this);
		for(Vente v : r) {
			System.out.println(v.getId()+" "+v.getVehicule().getMarque()+ " "+v.getClient().getNom()+" "+v.getPrixVente());
		}
	}
	
	public void vendre(Vehicule v, Client c, double prix, String options) {
		Manager.getTableVente();
		Vente vente = new Vente(mapVentes.getNextID(),c,this,v,"dateDuJour",prix,options);
		Manager.getTableVente().addVente(vente);
		//c.getListeVehicule().acheter(v);
		this.nbVentes++;
	}
	

	
}
