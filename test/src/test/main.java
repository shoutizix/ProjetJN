package test;

import java.util.Scanner;

public class main {
	
	static int multiplicateur;
	static Scanner scan = new Scanner(System.in);
	static char reponse = ' ';
	public static void main(String[] args) {
		//Fenetre f = new Fenetre();
		System.out.println("Combien de ligne(s) y a-t-il dans la matrice ? ");
		int nbreligne = scan.nextInt();
		System.out.println("Combien de colonne(s) y a-t-il dans la matrice ? ");
		int nbrecolonne = scan.nextInt();
		
		Matrice matrice = new Matrice(nbreligne,nbrecolonne);
		matrice.setValue();
		//vide la ligne de System.in
		scan.nextLine();
		System.out.println("Voulez-vous multiplier la matrice par un int ? (O/N)");
		 
		char reponse = scan.nextLine().charAt(0);
		
		if (reponse == 'O' || reponse == 'o') {
			System.out.println("Par quelle valeur voulez-vous multiplier la matrice ?");
			multiplicateur = scan.nextInt();
			matrice.multiplierParInt(multiplicateur);
		}
		
		else {
			System.out.println("Au revoir !");
		}
		
	}

}
