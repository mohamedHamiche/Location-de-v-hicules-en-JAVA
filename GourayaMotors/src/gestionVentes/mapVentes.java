package gestionVentes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import gestionComptes.Clients.*;
import gestionComptes.Personnel.Vendeur;


public class mapVentes {
	//hashmap key,ventes
	//ajouter supprimer
	//getVentes par marque , type  Vehicule
	//getVentes par client
	//getVentes par Vendeur
	
	Map <Integer, Vente> tableVente ;
	public mapVentes() {
		this.tableVente = new HashMap<Integer, Vente>();
	}
	
	public Vente getVente(int key) {
		return this.tableVente.get(key);
	}
	
	//retourne les ventes par client
	public ArrayList<Vente> getVentes(Client client) {
		ArrayList<Vente> r = new ArrayList<Vente>();	
		for(Integer key : this.tableVente.keySet()) {			
			Vente v = this.tableVente.get(key);
			if(v.getClient().getId() == client.getId()) {
				r.add(v);				
			}		
		}
		return r;
	}
	
	//retourne les ventes par Vendeur
	public ArrayList<Vente> getVentes(Vendeur vd) {
		ArrayList<Vente> r = new ArrayList<Vente>();	
		for(Integer key : this.tableVente.keySet()) {			
			Vente v = this.tableVente.get(key);
			if(v.getVendeur().getId() == vd.getId()) {
				r.add(v);				
			}		
		}
		return r;
	}
	//retourne les ventes par Vehicule
	public ArrayList<Vente> getVentes(String marque) {
		ArrayList<Vente> r = new ArrayList<Vente>();	
		for(Integer key : this.tableVente.keySet()) {			
			Vente v = this.tableVente.get(key);
			if(v.getVehicule().getMarque().equals(marque)) {
				r.add(v);				
			}		
		}
		return r;
	}

	public void addVente(Vente v) {
		this.tableVente.put(v.getId(), v);
	}
	
	public void deleteVente(Vente v) {
		this.tableVente.remove(v.getId());
	}
}
