package gestionComptes.Personnel;

public class mainPersonnel {

	public static void main(String[] args) {
		Directeur d = new DirecteurImp(4,"mdp","MR directeur","prenom1","0005848",8000);
		Salarie s = d.getTableSalarie().getSalarie(1);
		
		d.getTableSalarie().display();
		d.augmenter(s, 300);
		d.getTableSalarie().display();
	}

}
