package test;

import java.util.Scanner;

public class main {
	
	static int nbreligne;
	static int nbrecolonne;
	public static int multiplicateur;
	static Scanner scan = new Scanner(System.in);
	static String reponse;
	
	public static void main(String[] args) {
		//Fenetre f = new Fenetre();
		System.out.println("Combien de ligne(s)) y a-t-il dans la matrice ? ");
		nbreligne = scan.nextInt();
		System.out.println("Combien de colonne(s) y a-t-il dans la matrice ? ");
		nbrecolonne = scan.nextInt();
		
		Matrice matrice = new Matrice(nbreligne,nbrecolonne);
		matrice.setValue();
		
		/**System.out.println("Voulez-vous multiplier la matrice par un int ? (O/N)");
		 * 
		 * reponse = scan.nextString.charAt{0};
		
		if (reponse == "O") {
			MatriceMultipliee matrice2 = new MatriceMultipliee();
			matrice2.setValue();
		}
		
		else
			System.out.println("Au revoir !");**/
		
		
	}

}
