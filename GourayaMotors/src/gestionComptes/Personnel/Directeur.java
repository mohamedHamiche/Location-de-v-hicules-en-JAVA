package gestionComptes.Personnel;

public interface Directeur {
	//Embaucher un salarie listeSalarie.ajouter 
		//nbVentes=0 
	//Licencier un salarie listeSalarie.supprimer
	public void embaucher(Salarie s);
	public void licencier(Salarie s);
	public void augmenter(Salarie s, double marge);
	public void diminuer(Salarie s, double marge);
	public void displayTableSalarie();
	public mapSalarie getTableSalarie();
}
