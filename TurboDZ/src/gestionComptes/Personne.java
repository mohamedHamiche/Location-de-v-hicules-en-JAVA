package gestionComptes;

import java.util.Scanner;

import gestionComptes.Clients.Client;

public abstract class Personne {
	private final int id;
	private String pseudo;
	private String mdp;
	private String nom, prenom;
	private String tel;
	
	public Personne(int id, String pseudo,String mdp, String nom, String prenom, String tel) {
		super();
		this.id = id;
		this.pseudo=pseudo;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
	}
	//getters setters
	public int getId() {
		return id;
	}
	
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	//a appeler lors de l'ajout d'un client
	public static Client saisirClient() {
		String pseudo,mdp,nom,prenom,tel;
		System.out.println("choisir pseudo");
		try (Scanner sai_pseudo = new Scanner(System.in)) {
			pseudo = sai_pseudo.next();
		}
		System.out.println("choisir mdp");
		try (Scanner sai_mdp = new Scanner(System.in)) {
			mdp = sai_mdp.next();
		}
		System.out.println("choisir nom");
		try (Scanner sai_nom = new Scanner(System.in)) {
			nom = sai_nom.next();
		}
		System.out.println("choisir prenom");
		try (Scanner sai_prenom = new Scanner(System.in)) {
			prenom = sai_prenom.next();
		}
		System.out.println("choisir tel");
		try (Scanner sai_tel = new Scanner(System.in)) {
			tel = sai_tel.next();
		}
		Client c = new Client(pseudo,mdp,nom,prenom,tel);
		return c;
	}
}
