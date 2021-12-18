package gestionVehicules;

public class Vehicule {
	private int id;
	private String marque, modele;
	private TypeV type;
	private double prixBase;
	//constructeur pour les vehicules ajoutés par les clients
	public Vehicule(String marque, String modele) {
		this.id=-1;
		this.marque = marque;
		this.modele = modele;		
	}
	//constructeur pour les vehicules du catalogue 
	public Vehicule(String marque, String modele, TypeV type, double prixBase) {
		this.id = mapVehiculesAV.getNextID();
		this.marque = marque;
		this.modele = modele;
		this.type = type;
		this.prixBase = prixBase;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public TypeV getType() {
		return type;
	}
	public void setType(TypeV type) {
		this.type = type;
	}
	public double getPrixBase() {
		return prixBase;
	}
	public void setPrixBase(double prixBase) {
		this.prixBase = prixBase;
	}
	
	
	
}
