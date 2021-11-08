package gestionComptes.Personnel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class SalarieTest {
	private static Directeur d;
	
	@BeforeClass
	public static void init() {
		Directeur d = new DirecteurImp(4,"mdp","MR directeur","prenom1","0005848",8000);
	}
	
	@Test
	public void test_getSalarie() {
		Salarie s = d.getTableSalarie().getSalarie(1);
		assertEquals(1, s.getId());
	}
}
