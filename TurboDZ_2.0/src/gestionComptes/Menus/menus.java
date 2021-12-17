package gestionComptes.Menus;

import java.util.Scanner;

public abstract class menus {
	protected static String lireChaine() {
		String chaine=null;
			Scanner sai_chaine = new Scanner(System.in);
			chaine = sai_chaine.next();
		
		return chaine;
	}
	protected static int lireChoix() {
		int choix=0;
		Scanner sai_choix = new Scanner(System.in);
		choix = sai_choix.nextInt();
		
		return choix;
	}
	protected static float lireFloat() {
		float x=0;
		Scanner sai_choix = new Scanner(System.in);
		x = sai_choix.nextFloat();
		
		return x;
	}
	
}
