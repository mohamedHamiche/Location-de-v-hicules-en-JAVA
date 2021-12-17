package gestionVehicules;

public enum TypeV {
Citadine(1), Berline(2), Limousine(3), Break(4), SUV(5), Compacte(6), Coupe(7), Cabriolet(8);

private final int valeur;
	
	private TypeV(int v) {
		valeur=v;
	}
	
	public int getValeur() {
		return this.valeur;
	}
}
