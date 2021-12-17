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
	
	private static Map <Integer, Vente> tableVente ;
	public mapVentes() {
		tableVente = new HashMap<Integer, Vente>();
	}
	
	public Vente getVente(int key) {
		return tableVente.get(key);
	}
	
	//retourne les ventes par client
	public static ArrayList<Vente> getVentes(Client client) {
		ArrayList<Vente> r = new ArrayList<Vente>();	
		for(Integer key : tableVente.keySet()) {			
			Vente v = tableVente.get(key);
			if(v.getClient().getId() == client.getId()) {
				r.add(v);				
			}		
		}
		return r;
	}
	

	public static void displayVentes(Vendeur vd) {		
		for(Integer key : tableVente.keySet()) {			
			Vente v = tableVente.get(key);
			if(v.getVendeur().getId() == vd.getId()) {
				System.out.println("client: "+v.getClient().getPseudo());
				System.out.println("vendeur: "+v.getVendeur().getPseudo());
				System.out.println("date: "+v.getDateVente());
				System.out.println("prix: "+v.getPrixVente());
			}		
		}		
	}
	public static void displayVentes(String marque) {		
		for(Integer key : tableVente.keySet()) {			
			Vente v = tableVente.get(key);
			if(v.getVehicule().getMarque().equals(marque)) {
				System.out.println("client: "+v.getClient().getPseudo());
				System.out.println("vendeur: "+v.getVendeur().getPseudo());
				System.out.println("date: "+v.getDateVente());
				System.out.println("prix: "+v.getPrixVente());
			}		
		}		
	}

	public static void addVente(Vente v) {
		tableVente.put(v.getId(), v);
	}
	
	public static void deleteVente(Vente v) {
		tableVente.remove(v.getId());
	}
	
	public static int getNextID(){
		return tableVente.size()+1;
	}
}
