package gestionVehicules;

import java.util.HashMap;
import java.util.Map;



public class mapVehiculesAV {
	
	private static Map<Integer, Vehicule> tableVehicule;

	public mapVehiculesAV() {
		mapVehiculesAV.tableVehicule = new HashMap<Integer, Vehicule>();	
		tableVehicule.put(1, new Vehicule("BMW","m5",TypeV.Berline,31900));
		tableVehicule.put(2, new Vehicule("Mercedes","c220",TypeV.Coupe,22900));
		tableVehicule.put(3, new Vehicule("VW","Golf 8",TypeV.Compacte,26900));
	}
	
	public static int getNextID(){
		return tableVehicule.size()+1;
	}

	public static Map<Integer, Vehicule> getTableVehicule() {
		return tableVehicule;
	}
	
	public static void addVehicule(Vehicule v) {
		mapVehiculesAV.tableVehicule.put(tableVehicule.size(), v);
	}
	
	public static Vehicule getVehicule(int key) {
		return mapVehiculesAV.tableVehicule.get(key);
	}
	
	public static void deleteVehicule(int key) {
		mapVehiculesAV.tableVehicule.remove(key);
	}
	
	//afficher tous le catalogue
	public static void displayCatalogue() {		
		for(Integer key : mapVehiculesAV.getTableVehicule().keySet()) {
			Vehicule v= mapVehiculesAV.getVehicule(key);
			System.out.println(v.getId()+" "+v.getMarque()+ " "+v.getModele()+" "+v.getType()+" "+v.getPrixBase()+" Euros");
		}
	}
	
	//par type du vehicule
	public static void displayCatalogue(int type) {		
		for(Integer key : mapVehiculesAV.getTableVehicule().keySet()) {
			Vehicule v= mapVehiculesAV.getVehicule(key);
			if(v.getType().getValeur()==type)
				System.out.println(v.getId()+" "+v.getMarque()+ " "+v.getModele()+" "+v.getType()+" "+v.getPrixBase()+" Euros");
		}
	}
	//par marque
	public static void displayCatalogue(String marque) {		
		for(Integer key : mapVehiculesAV.getTableVehicule().keySet()) {
			Vehicule v= mapVehiculesAV.getVehicule(key);
			if(v.getMarque().equals(marque))
				System.out.println(v.getId()+" "+v.getMarque()+ " "+v.getModele()+" "+v.getType()+" "+v.getPrixBase()+" Euros");
		}
	}
}
