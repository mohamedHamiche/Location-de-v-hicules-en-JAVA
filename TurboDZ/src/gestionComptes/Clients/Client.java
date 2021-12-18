package gestionComptes.Clients;

import java.util.ArrayList;
import java.util.Scanner;

import gestionComptes.Personne;
import gestionVehicules.Vehicule;
import gestionVehicules.mapVehiculesAV;
import gestionEntretiens.*;
import gestionComptes.Personnel.Receptionnaire;
import gestionComptes.Personnel.Technicien;

public class Client extends Personne{
/*	Dispose d'une liste de ses vehicules -->peut ajouter lui meme un vehicule qu'il a acquis en dehors 
 * 			de notre concession ou peut etre ajouté par le vendeur s'il achete chez nous
 */
	
	//peut voir le catalogue :mapVehiculesAV methode qui n'est pas propre a un seul client appel dans le main
	//peut voir l'historique de ses achats: vehicules achetes, mapVentes.display(this)
	//peut voir l'historique de ses entretiens: mapEntretien.display(this)
	
	/*peut demander un entretien pour un de ses vehicules: 
		Entretien e=new Entretien(this, leVchoisi, dateEntreeSouhaite);
		mapEntretien.add(e);
		+transmission en atelier par le recep.si garage dispo
		*/
	private ArrayList<Vehicule> listeV ;
	
	public Client(String pseudo, String mdp, String nom, String prenom, String tel) {
		super(mapClients.getNextID(),pseudo, mdp, nom, prenom, tel);
		this.listeV=new ArrayList<Vehicule>();
	}

	public ArrayList<Vehicule> getListeV() {
		return listeV;
	}

	public void setListeV(ArrayList<Vehicule> listeV) {
		this.listeV = listeV;
	}
	
	//un client demande entretien: creation d'une fiche d'entretien pour le vehicule concerné à la date voulue
	public void demandeEntretien(int index, String dateE, String description) {	
		Vehicule v=null;
		v=this.listeV.get(index-1);
		if(v==null) {
			System.out.println("Erreur le vehicule souhaité n'existe pas !");			
		}
		Entretien e = new Entretien(v,this,dateE,description); 
		mapEntretien.addEntretien(e);
		Technicien t=Receptionnaire.choixTech();
		if(t!=null) {
			Receptionnaire.transmetEntretien(e,t);
		}
		
		//si c'est null quand est ce qu'il sera transmit ? le receptionaire le fera 
	}
	
	
	public void addV(Vehicule v) {		
		this.listeV.add(v);		
	}
	
	public void afficherMesVehicules() {	
		int index=1;
		for(Vehicule v : this.listeV) {
			System.out.println(index+" "+v.getMarque()+ " "+v.getModele());
			index+=1;
		}		
		
	}
}
 