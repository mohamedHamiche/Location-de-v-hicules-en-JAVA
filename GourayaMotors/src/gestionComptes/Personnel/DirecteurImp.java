package gestionComptes.Personnel;

import gestionVentes.mapVentes;

public class DirecteurImp extends Salarie implements Directeur{
	private mapSalarie tableSalarie;
	private static mapVentes tableVente;
	
	public DirecteurImp(int id, String pseudo,String mdp, String nom, String prenom, String tel, double salaire) {
		super(pseudo, mdp, nom, prenom, tel, salaire);
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
		if(!s.equals(this)){
			this.tableSalarie.deleteSalarie(s);	
		}
		//le directeur ne peut pas se licencier lui meme		
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

	public static mapVentes getTableVente() {
		return tableVente;
	}

	
	
	
	
	
}
