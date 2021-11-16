package gestionEntretiens;


import gestionComptes.Clients.Client;
import gestionVehicules.Vehicule;

public class Entretien {
	private final int id;
	private final Vehicule v;
	private final Client client;
	private Etat etat;
	private final String dateE;
	private String dateS;
	private String description;
	private String rapport;
	private double tarif;
	
	//constructeur: a la creation d'une fiche d'entretien on a besoin des infos du client du vehicule et la dateE
	//une description des reparations ou operations a effectuer sur le vehicule
	
	//une fois le vehicule repare : le techicien mets l'etat de l'entretien à "Termine"
	//		le receptionnaire notifie le client, et met l'etat de l'entretien remis 
	//qaund le client recupere son vehicule, et note la date de sortie et le tarif
	public Entretien(Vehicule v, Client client, String dateE, String description) {		
		this.id = mapEntretien.getNextID();
		this.v = v;
		this.client = client;
		this.etat=Etat.EnCours;
		this.dateE = dateE;
		this.description = description;		
	}

	public Vehicule getV() {
		return v;
	}

	public Client getClient() {
		return client;
	}
	
	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public String getDateE() {
		return dateE;
	}
	
	public String getDateS() {
		return dateS;
	}

	public void setDateS(String dateS) {
		this.dateS = dateS;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRapport() {
		return rapport;
	}

	public void setRapport(String rapport) {
		this.rapport = rapport;
	}

	public double getTarif() {
		return tarif;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
	}

	public int getId() {
		return id;
	}
	
	
}
