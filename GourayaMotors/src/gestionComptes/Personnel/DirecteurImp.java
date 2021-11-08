package gestionComptes.Personnel;


public class DirecteurImp extends Salarie implements Directeur{
	private mapSalarie tableSalarie;

	public DirecteurImp(int id, String mdp, String nom, String prenom, String tel, double salaire) {
		super(id, mdp, nom, prenom, tel, salaire);
		this.setFct(Fonction.Directeur);
		this.tableSalarie =new mapSalarie();
	}
	
	public mapSalarie getTableSalarie() {
		return tableSalarie;
	}


	@Override
	public void embaucher(Salarie s) {
		this.tableSalarie.addSalarie(s);		
	}

	@Override
	public void licencier(Salarie s) {
		this.tableSalarie.deleteSalarie(s);	
		
	}

	@Override
	public void augmenter(Salarie s, double marge) {		
		this.tableSalarie.augmenter(s,marge);
	}
	
	@Override
	public void diminuer(Salarie s, double marge) {
		this.tableSalarie.diminuer(s,marge);
		
	}

	@Override
	public void displayTableSalarie() {
		this.tableSalarie.display();
	}

	
	
	
	
	
}
