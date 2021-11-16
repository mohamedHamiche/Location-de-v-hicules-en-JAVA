package gestionComptes;

import gestionComptes.Clients.mapClients;
import gestionComptes.Personnel.mapSalarie;
import gestionVentes.mapVentes;

public class Database {
	//base de données contenat les maps dont on a besoin
	private static mapSalarie tableSalarie; 
	private static mapVentes tableVente;
	private static mapClients tableClient;
	
	
	public Database() {
		Database.tableSalarie= new mapSalarie();
		Database.tableVente= new mapVentes();
		Database.tableClient= new mapClients();
	}

	public static mapSalarie getTableSalarie() {
		return tableSalarie;
	}
	
	public static mapVentes getTableVente() {
		return tableVente;
	}
	
	public static mapClients getTableClient() {
		return tableClient;
	}
	
	public void displayTableSalarie() {
		tableSalarie.display();
	}

	public static void setTableSalarie(mapSalarie tableSalarie) {
		Database.tableSalarie = tableSalarie;
	}

	public static void setTableVente(mapVentes tableVente) {
		Database.tableVente = tableVente;
	}

	public static void setTableClient(mapClients tableClient) {
		Database.tableClient = tableClient;
	}
}
