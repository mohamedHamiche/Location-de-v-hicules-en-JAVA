package gestionComptes.Personnel;
import java.util.HashMap;
import java.util.Map;

public class mapSalarie {
	private static Map <Integer, Salarie> tableSalarie ;
	
	public mapSalarie() {
		mapSalarie.tableSalarie = new HashMap<Integer, Salarie>();
		tableSalarie.put(1, new Vendeur("vendeur1","mdp","HAMICHE","Mohamed","0005848",1320));
		tableSalarie.put(2, new Technicien("tech1","mdp","CHELLAGHA","Lamine","0005849",1500));
		tableSalarie.put(3, new Receptionnaire("recep","mdp","FERROUKHI","Nail","0005840",1500));
		//charger le fichier des salaries
	} 
	
	public static int getNextID(){
		return mapSalarie.tableSalarie.size()+1;
	}
	
	public static Map<Integer, Salarie> getTableSalarie() {
		return tableSalarie;
	}

	public static Salarie getSalarie(int key) {
		return mapSalarie.tableSalarie.get(key);
	}
	
	public static Receptionnaire getReceptionnaire(int key) {
		return (Receptionnaire) mapSalarie.tableSalarie.get(key);
	}
	public static Manager getManager(int key) {
		return (Manager) mapSalarie.tableSalarie.get(key);
	}
	
	public static Salarie getSalarie(String pseudo, String mdp) {
		Salarie r=null;
		for(Integer key : mapSalarie.tableSalarie.keySet()) {
			Salarie t = mapSalarie.tableSalarie.get(key);
			if(t.getPseudo().equals(pseudo) && t.getMdp().equals(mdp)) {
				r=t;
			}
		}
		return r;
	}

	public static void addSalarie(Salarie s) {
		mapSalarie.tableSalarie.put(s.getId(), s);
	}
	
	public static void deleteSalarie(int key) {
		mapSalarie.tableSalarie.remove(key);
	}
	
	
	
	public static void display() {
		System.out.println("-------------- Liste des salariés -----------");
		for(Integer key : mapSalarie.tableSalarie.keySet()) {
			Salarie t = mapSalarie.tableSalarie.get(key);
			System.out.println(t.getId()+" "+t.getNom()+" "+ t.getPrenom()+" "+t.getSalaire()+" "+t.getTel()+" "+t.getFct());
		}
	}
	
	public void display(int key) {
		Salarie t = mapSalarie.tableSalarie.get(key);
		System.out.println(t.getId()+" "+t.getNom()+" "+ t.getPrenom()+" "+t.getSalaire()+" "+t.getTel()+" "+t.getFct());
	}
}
