package gestionComptes.Clients;

import java.util.HashMap;
import java.util.Map;


public class mapClients {
	private static Map<Integer, Client> tableClient;

	public mapClients(Map<Integer, Client> tableClient) {
		mapClients.tableClient = new HashMap<Integer, Client>();
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
}
