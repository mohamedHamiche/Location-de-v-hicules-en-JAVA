package gestionComptes.Personnel;

import java.util.ArrayList;

import java.util.Scanner;

import gestionEntretiens.Entretien;
import gestionEntretiens.Etat;
import gestionVehicules.Vehicule;



public class Technicien extends Salarie {

	//dispo: le nombre d'entretiens qu'il peut recevoir en plus
	private ArrayList<Entretien> listeE; 
	private int dispo;
	
	public Technicien(String pseudo, String mdp, String nom, String prenom, String tel, double salaire) {
		super(pseudo, mdp, nom, prenom, tel, salaire);
		this.setFct(Fonction.Technicien);
		this.listeE= new ArrayList<Entretien>();
		this.dispo=5;
	}

	public ArrayList<Entretien> getListeE() {
		return this.listeE;
	}

	public void setListeE(ArrayList<Entretien> listeE) {
		this.listeE = listeE;
	}

	public int getDispo() {
		return this.dispo-this.listeE.size();
	}

	public void setDispo(int dispo) {
		this.dispo = dispo;
	}

	public boolean ajoutEntretien(Entretien e) {
		if(this.getDispo()>0) {
			this.listeE.add(e);
			return true;
		}
		else {
			System.out.println("Le technicien : "+this.getNom()+" "+this.getPrenom()+" n'est pas disponible pour le moment !");
			return false;
		}
	}
	
	public void supprimerEntretien(int key) {				
		this.listeE.remove(key);		
	}
	
	public void displayEntretiens() {
		int index=1;
		for(Entretien e : this.listeE) {
			System.out.println(index+" "+e.getV().getMarque()+ " "+e.getV().getModele());
			System.out.println("     Date entrée:"+e.getDateE());
			System.out.println("     Description:"+e.getDescription());
		}		
	}
	
	
	
}
