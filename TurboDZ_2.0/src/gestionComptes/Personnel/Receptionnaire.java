package gestionComptes.Personnel;



import gestionEntretiens.*;

public class Receptionnaire extends Salarie {
	//hashMap<key,ficheEntrerien> : classe mapEntretiens
		//liste tehniciens mapSalarie.i.fct='Technicien'
		
		//affecterVehiculeTechnicien  selon dispo(minimale): ficheE.technicien=t
		//t.listVaREP.ajouter 
		//quand t.repare : receptionnaire.ficheE.entretienValide(); deja fait dans technicien
		//si client recupere ficheE.Sortie
	private static mapEntretien lesEntretiens;
	
	public Receptionnaire(String pseudo, String mdp, String nom, String prenom, String tel, double salaire) {
		super(pseudo, mdp, nom, prenom, tel, salaire);
		this.setFct(Fonction.Receptionnaire);
		lesEntretiens= new mapEntretien();
		
	}

	public mapEntretien getLesEntretiens() {
		return lesEntretiens;
	}
	
	public static Technicien choixTech() {
		Technicien t,tMax=null;
		int max = 0;
		for(int key : mapSalarie.getTableSalarie().keySet()) {
			Salarie s = mapSalarie.getSalarie(key);
			if(s.getFct()==Fonction.Technicien)
			{
				t= (Technicien)s;				
				if(t.getDispo()>max) {
					tMax=t;
				}
			}
		}
		
		return tMax;
	}
	//bien verifier que tMax est non null avant de transmettre 
	public static void transmetEntretien(Entretien e,Technicien t) {
		t.ajoutEntretien(e);
	}
	
	public void afficherEntretiens(Etat e) {
		for(int key : mapEntretien.getTableEntretien().keySet()) {
			Entretien ent = mapEntretien.getEntretien(key);
			if(ent.getEtat()==e)
			{
				System.out.println("-----------------------"+ent.getId()+" -------------");
				System.out.println("Infos Client: ");
				System.out.println(ent.getClient().getNom()+" "+ent.getClient().getPrenom()+" "+ent.getClient().getTel());
				System.out.println("Infos Vehicule: ");
				System.out.println(ent.getV().getId()+" "+ent.getV().getMarque()+" "+ent.getV().getModele());
				System.out.println("Description: \n"+ent.getDescription());
				System.out.println("Rapport du technicien: "+ent.getRapport());
				System.out.println("Date entrée: "+ent.getDateE()+"\nDate sortie: "+ent.getDateS());				
				System.out.println("Tarif: "+ent.getTarif());				
			}
		}
	}
	
	
	
}
