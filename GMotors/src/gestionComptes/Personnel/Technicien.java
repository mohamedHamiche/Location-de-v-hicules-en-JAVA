package gestionComptes.Personnel;

import java.util.ArrayList;

import java.util.Scanner;

import gestionEntretiens.Entretien;
import gestionEntretiens.Etat;



public class Technicien extends Salarie {
	//liste des entretiens a effectuer --- afficher ajouter valider
		//reparer vehicule: entretien.etat=pret
	private ArrayList<Entretien> listeE; 
	private int dispo;
	
	public Technicien(String pseudo, String mdp, String nom, String prenom, String tel, double salaire) {
		super(pseudo, mdp, nom, prenom, tel, salaire);
		this.setFct(Fonction.Technicien);
		this.listeE= new ArrayList<Entretien>();
		this.dispo=5;
	}

	public ArrayList<Entretien> getListeE() {
		return listeE;
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
	
	public void validerEntretien(Entretien e) {
		e.setEtat(Etat.Termine);
		try (Scanner scanner = new Scanner(System.in)) {
			String rapport = scanner.nextLine();
			e.setRapport(rapport);
		}
		this.listeE.remove(e);
		//receptionnaire.notifierClient//setTarif
	}
	
	//public void display(ArrayList<Entretien>){};
	
	
	
}
