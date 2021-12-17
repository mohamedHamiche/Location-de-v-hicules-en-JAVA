package gestionComptes.Clients;

import java.util.HashMap;
import java.util.Map;

import gestionComptes.Personnel.Salarie;
import gestionComptes.Personnel.Vendeur;
import gestionComptes.Personnel.mapSalarie;


public class mapClients {
	private static Map<Integer, Client> tableClient;

	public mapClients() {
		mapClients.tableClient = new HashMap<Integer, Client>();
		tableClient.put(1, new Client("client1","mdp","CR7","ronaldo","055471055"));
		//charger le fichier des clients
	}
	
	public static int getNextID(){
		return tableClient.size()+1;
	}
	
	public static Map<Integer, Client> getTableClient() {
		return tableClient;
	}
	
	public static void addClient(Client c) {
		mapClients.tableClient.put(tableClient.size(), c);
	}
	
	public static Client getClient(int key) {
		return mapClients.tableClient.get(key);
	}
	
	public static Client getClient(String pseudo, String mdp) {
		Client r=null;
		for(Integer key : mapClients.tableClient.keySet()) {
			Client t = mapClients.tableClient.get(key);
			if(t.getPseudo().equals(pseudo) && t.getMdp().equals(mdp)) {
				r=t;
			}
		}
		return r;
	}
	public static Client getClient(String pseudo) {
		Client r=null;
		for(Integer key : mapClients.tableClient.keySet()) {
			Client t = mapClients.tableClient.get(key);
			if(t.getPseudo().equals(pseudo)) {
				r=t;
			}
		}
		return r;
	}
	public static void display() {
		System.out.println("-------------- Liste des clients -----------");
		for(Integer key : mapClients.tableClient.keySet()) {
			Client c = mapClients.tableClient.get(key);
			System.out.println(c.getId()+" "+c.getNom()+" "+ c.getPrenom()+" "+c.getTel());
		}
	}
}
