package gestionVehicules;

import java.util.HashMap;
import java.util.Map;




public class mapVehiculesAV {
	//hashmap 
	//ajouter supprimer
	private static Map<Integer, Vehicule> tableVehicule;

	public mapVehiculesAV() {
		mapVehiculesAV.tableVehicule = new HashMap<Integer, Vehicule>();		
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
	
	public static void deleteVehicule(Vehicule v) {
		mapVehiculesAV.tableVehicule.remove(v.getId());
	}
	
	//afficher tous le catalogue
	public static void displayCatalogue() {		
		for(Integer key : mapVehiculesAV.getTableVehicule().keySet()) {
			Vehicule v= mapVehiculesAV.getVehicule(key);
			System.out.println(v.getId()+" "+v.getMarque()+ " "+v.getModele()+" "+v.getType()+" "+v.getPrixBase()+" Euros");
		}
	}
	
	//par type du vehicule
	public static void displayCatalogue(TypeV type) {		
		for(Integer key : mapVehiculesAV.getTableVehicule().keySet()) {
			Vehicule v= mapVehiculesAV.getVehicule(key);
			if(v.getType().equals(type))
				System.out.println(v.getId()+" "+v.getMarque()+ " "+v.getModele()+" "+v.getType()+" "+v.getPrixBase()+" Euros");
		}
	}
	//marque
	public static void displayCatalogue(String marque) {		
		for(Integer key : mapVehiculesAV.getTableVehicule().keySet()) {
			Vehicule v= mapVehiculesAV.getVehicule(key);
			if(v.getMarque().equals(marque))
				System.out.println(v.getId()+" "+v.getMarque()+ " "+v.getModele()+" "+v.getType()+" "+v.getPrixBase()+" Euros");
		}
	}
}
