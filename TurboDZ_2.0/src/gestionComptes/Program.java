package gestionComptes;

import gestionComptes.Menus.menuGeneral;

public class Program {

	public static void main(String[] args) {
		System.out.println("--- Bienvenue ----");
		Database db = new Database();				
		menuGeneral menuG = new menuGeneral();
		menuG.executeMenu();

	}

}
