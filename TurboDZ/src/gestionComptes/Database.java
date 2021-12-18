package gestionComptes;

import gestionComptes.Clients.mapClients;
import gestionComptes.Personnel.mapSalarie;
import gestionVehicules.mapVehiculesAV;
import gestionVentes.mapVentes;

public class Database {
	//base de données contenat les maps dont on a besoin
	private static mapSalarie tableSalarie; 
	private static mapVentes tableVente;
	private static mapClients tableClient;
	private static mapVehiculesAV tableVehicule;
	
	public Database() {
		Database.tableSalarie= new mapSalarie();
		Database.tableVente= new mapVentes();
		Database.tableClient= new mapClients();
		Database.tableVehicule= new mapVehiculesAV();
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

	public static mapVehiculesAV getTableVehicule() {
		return tableVehicule;
	}
		
}
