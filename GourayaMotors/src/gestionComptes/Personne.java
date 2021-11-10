package gestionComptes;

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
	//se connecter se deconnecter
	//creer un compte
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
}
