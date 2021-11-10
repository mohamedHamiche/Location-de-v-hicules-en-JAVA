package gestionComptes.Clients;

import java.util.HashMap;
import java.util.Map;


public class mapClients {
	private static Map<Integer, Client> tableClient;

	public mapClients(Map<Integer, Client> tableClient) {
		mapClients.tableClient = new HashMap<Integer, Client>();
	}
	
	public static int getNextID(){
		return tableClient.size();
	}
	
	public static Map<Integer, Client> getTableClient() {
		return tableClient;
	}

}
