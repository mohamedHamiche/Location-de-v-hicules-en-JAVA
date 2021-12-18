package gestionEntretiens;


import java.util.HashMap;
import java.util.Map;

import gestionComptes.Clients.Client;



public class  mapEntretien {
	private static Map<Integer, Entretien> tableEntretien;

	public mapEntretien() {
		mapEntretien.tableEntretien = new HashMap<Integer, Entretien>();
		//charger fichier des entretien
	}

	public static Map<Integer, Entretien> getTableEntretien() {
		return tableEntretien;
	}

	public void setTableEntretien(Map<Integer, Entretien> tableEntretien) {
		mapEntretien.tableEntretien = tableEntretien;
	}
	
	public static Entretien getEntretien(int key) {
		return mapEntretien.tableEntretien.get(key);
	}
	
	public static int getNextID(){
		return tableEntretien.size();
	}
	public static void addEntretien(Entretien e) {
		tableEntretien.put(e.getId(), e);
	}
	
	public static void deleteEntretien(Entretien e) {
		tableEntretien.remove(e.getId());
	}
	
	public static void updateEntretien(Entretien e) {
		tableEntretien.replace(e.getId(), e);
	}
	
	public static void displayEtat(Client cli) {
		for(Integer key : mapEntretien.getTableEntretien().keySet()) {
			Entretien e= mapEntretien.getEntretien(key);
			if(e.getClient().getId()==cli.getId()) {
				System.out.println(e.getId()+1+" "+e.getV().getMarque()+" "+e.getV().getModele()+" "+e.getEtat().toString()+" "+e.getDateS()+" "+e.getTarif());
			}			
		}
	}

}
