package test;

import java.util.Scanner;

public class main {
	
	static int multiplicateur;
	static Scanner scan = new Scanner(System.in);
	static char reponse = ' ';
	
	
	public static void main(String[] args) {
		

		System.out.println("Combien y a-t-il de x ?");
		int nbreX = scan.nextInt();
		System.out.println("Combien y a-t-il de contraintes ?");
		int nbreContraintes = scan.nextInt();
		AlgoSimplex lol = new AlgoSimplex(nbreContraintes, nbreX);
		lol.showStandardForm();
		
	}
	


}
