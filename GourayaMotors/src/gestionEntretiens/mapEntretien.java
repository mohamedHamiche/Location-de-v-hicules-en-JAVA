package gestionEntretiens;

import java.util.HashMap;
import java.util.Map;

public class  mapEntretien {
	private static Map<Integer, Entretien> tableEntretien;

	public mapEntretien(Map<Integer, Entretien> tableEntretien) {
		mapEntretien.tableEntretien = new HashMap<Integer, Entretien>();
	}

	public Map<Integer, Entretien> getTableEntretien() {
		return tableEntretien;
	}

	public void setTableEntretien(Map<Integer, Entretien> tableEntretien) {
		mapEntretien.tableEntretien = tableEntretien;
	}
	
	public static int getNextID(){
		return tableEntretien.size();
	}
}
