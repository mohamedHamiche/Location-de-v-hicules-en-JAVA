package gestionComptes.Personnel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import gestionComptes.Database;

class SalarieTest {
	private static Manager d;
	
	@BeforeClass
	public static void init() {
		Database db =new Database();
		Vendeur v = new Vendeur("testPseudo","testMdp","testNom","testPrenom","testTel",999.0);
	}
	
	@Test
	public void test_getSalarie() {			
		Database.getTableSalarie();
		Salarie v2 = mapSalarie.getSalarie(1);
		
	//	assertEquals(v2.getSalaire(), v.getSalaire());
		//erreur
	}
}
