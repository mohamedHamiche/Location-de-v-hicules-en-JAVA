package gestionComptes.Clients;

import java.util.HashMap;
import java.util.Map;


import gestionVehicules.Vehicule;


public class mapClients {
	private static Map<Integer, Client> tableClient;

	public mapClients() {
		mapClients.tableClient = new HashMap<Integer, Client>();
		Client client1=new Client("client1","mdp","CR7","ronaldo","055471055");
		client1.addV(new Vehicule("Porshe","Macan S"));
		client1.addV(new Vehicule("Subaru","Impreza"));
		tableClient.put(1, client1);
		Client client2=new Client("client2","mdp","Khani","Hossein","070001099");
		client2.addV(new Vehicule("Lamborgini","Urus"));
		client2.addV(new Vehicule("VW","Passat"));
		tableClient.put(2, client2); 
		
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
