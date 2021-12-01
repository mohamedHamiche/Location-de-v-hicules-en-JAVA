package gestionEntretiens;

import java.util.HashMap;
import java.util.Map;

import gestionComptes.Personnel.Salarie;
import gestionComptes.Personnel.mapSalarie;


public class  mapEntretien {
	private static Map<Integer, Entretien> tableEntretien;

	public mapEntretien() {
		mapEntretien.tableEntretien = new HashMap<Integer, Entretien>();
	}

	public Map<Integer, Entretien> getTableEntretien() {
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
}
