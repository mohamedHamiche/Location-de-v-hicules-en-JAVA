package gestionVentes;
import gestionComptes.Clients.Client;
import gestionComptes.Personnel.Vendeur;
import gestionVehicules.Vehicule;

public class Vente {
	//fiche de vente 
	private static int id;
	private Client client;
	private Vendeur vendeur;
	private Vehicule vehicule; 
	private String dateVente;
	private double prixVente;
	private String options;
		
	public Vente(int id, Client client, Vendeur vendeur, Vehicule vehicule, String dateVente, double prixVente,
			String options) {
		Vente.id=id;
		this.client = client;
		this.vendeur = vendeur;
		this.vehicule = vehicule;
		this.dateVente = dateVente;
		this.prixVente = prixVente;
		this.options = options;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Vendeur getVendeur() {
		return vendeur;
	}
	public void setVendeur(Vendeur vendeur) {
		this.vendeur = vendeur;
	}
	public Vehicule getVehicule() {
		return vehicule;
	}
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	public String getDateVente() {
		return dateVente;
	}
	public void setDateVente(String dateVente) {
		this.dateVente = dateVente;
	}
	public double getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public int getId() {
		return id;
	}
	
	
	//getters setters
	
}
