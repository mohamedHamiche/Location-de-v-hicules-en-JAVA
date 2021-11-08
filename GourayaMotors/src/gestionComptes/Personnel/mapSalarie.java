package gestionComptes.Personnel;
import java.util.HashMap;
import java.util.Map;

public class mapSalarie {
	Map <Integer, Salarie> tableSalarie ;
	
	public mapSalarie() {
		this.tableSalarie = new HashMap<Integer, Salarie>();
		tableSalarie.put(1, new Vendeur(1,"mdp","name1","prenom1","0005848",1320));
		tableSalarie.put(2, new Technicien(2,"mdp","name2","prenom2","0005849",1500));
		tableSalarie.put(3, new Receptionnaire(3,"mdp","name2","prenom3","0005840",1500));
	}
	
	public Salarie getSalarie(int key) {
		return this.tableSalarie.get(key);
	}

	public void addSalarie(Salarie s) {
		this.tableSalarie.put(s.getId(), s);
	}
	
	public void deleteSalarie(Salarie s) {
		this.tableSalarie.remove(s.getId());
	}
	
	public void augmenter(Salarie s, double marge) {
		s.setSalaire(s.getSalaire()+marge);
		this.tableSalarie.put(s.getId(), s);
	}
	
	public void diminuer(Salarie s, double marge) {
		s.setSalaire(s.getSalaire()-marge);
		this.tableSalarie.put(s.getId(), s);
	}
	
	public void display() {
		for(Integer key : this.tableSalarie.keySet()) {
			Salarie t = this.tableSalarie.get(key);
			System.out.println(t.getId()+" "+t.getNom()+" "+ t.getPrenom()+" "+t.getSalaire()+" "+t.getTel()+" "+t.getFct());
		}
	}
	
	public void display(int key) {
		Salarie t = this.tableSalarie.get(key);
		System.out.println(t.getId()+" "+t.getNom()+" "+ t.getPrenom()+" "+t.getSalaire()+" "+t.getTel()+" "+t.getFct());
	}
}
