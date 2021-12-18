package gestionComptes.Personnel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import gestionComptes.Database;

class SalarieTest {
	static Vendeur v;
	private static Database db;
	@BeforeClass
	public static void init() {	
		db = new Database();
		 v = new Vendeur("vendeur1","mdp","testNom","testPrenom","testTel",999.0);		
	}
	
	@Test
	public void test_getFonction() {			
		int id =mapSalarie.getTableSalarie().size();
		Vendeur v2 = (Vendeur) mapSalarie.getSalarie(id);
		
		assertEquals(v2.getNom(), v.getNom());
		assertEquals(v2.getSalaire(), v.getSalaire());
		
	}
}
