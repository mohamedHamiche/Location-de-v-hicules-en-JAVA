package gestionComptes.Personnel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class SalarieTest {
	private static Manager d;
	
	@BeforeClass
	public static void init() {
		Manager d = new Manager(1,"directpseudo","mdp","MR directeur","prenom1","0005848",8000);
	}
	
	@Test
	public void test_getSalarie() {		
		d.getTableSalarie();
		Salarie s = mapSalarie.getSalarie(1);
		assertEquals(1, s.getId());
	}
}
