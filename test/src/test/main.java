package test;

import java.util.Scanner;

public class main {
	
	static int multiplicateur;
	static Scanner scan = new Scanner(System.in);
	static char reponse = ' ';
	
	
	public static void main(String[] args) {
		System.out.println("Combien de ligne(s) y a-t-il dans la matrice ? ");
		int nbreligne = scan.nextInt();
		System.out.println("Combien de colonne(s) y a-t-il dans la matrice ? ");
		int nbrecolonne = scan.nextInt();
		
		Matrice matrice = new Matrice(nbreligne,nbrecolonne);
		
		//vide la ligne de System.in
		scan.nextLine();
		System.out.println("Voulez-vous mettre des valeurs ? (O/N)");
				 
		reponse = scan.nextLine().charAt(0);
				
		if (reponse == 'O' || reponse == 'o') {
			matrice.setValue();
		} else {
			matrice.valeurParDefaut();
		}
		
		
		//Multiplier 2 matrices ensemble
		System.out.println("Voulez-vous multiplier la matrice par une autre matrice ? (O/N)");
		
		reponse = scan.nextLine().charAt(0);
		
		if (reponse == 'O' || reponse == 'o') {
			System.out.println("Combien de ligne(s) y a-t-il dans la matrice ? ");
			int nbreligne2 = scan.nextInt();
			System.out.println("Combien de colonne(s) y a-t-il dans la matrice ? ");
			int nbrecolonne2 = scan.nextInt();
			
			Matrice matrice2 = new Matrice(nbreligne2,nbrecolonne2);
			
			matrice2.setValue();
			
			matrice.multiplierParMatrice(matrice2);
			
			//vide la ligne de System.in
			scan.nextLine();
		} 		
		
		
		System.out.println("Voulez-vous voir la matrice inverse ? (O/N)");
		 
		reponse = scan.nextLine().charAt(0);
		
		if (reponse == 'O' || reponse == 'o') {
			matrice.calculerInverse();
		}
		
		System.out.println("Voulez-vous multiplier la matrice par un int ? (O/N)");
		 
		reponse = scan.nextLine().charAt(0);
		
		if (reponse == 'O' || reponse == 'o') {
			System.out.println("Par quelle valeur voulez-vous multiplier la matrice ?");
			multiplicateur = scan.nextInt();
			matrice.multiplierParInt(multiplicateur);
		}
		
		else {
			System.out.println("Au revoir !");
		}
/**
		System.out.println("Combien y a-t-il de x ?");
		int nbreX = scan.nextInt();
		System.out.println("Combien y a-t-il de contraintes ?");
		int nbreContraintes = scan.nextInt();
		AlgoSimplex lol = new AlgoSimplex(nbreContraintes, nbreX);
		lol.showStandardForm();
		**/
	}
	


}
