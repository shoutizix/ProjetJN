package test;

import java.util.Scanner;

public class Matrice {
	
	int m, n, value; // m = nbre de lignes et n = nbre de colonnes
	int[][] matrice, inverse, matriceMultipliee;
	int multiplicateur;
	Scanner scan = new Scanner(System.in);
	String reponse;
	
	
	
	public Matrice (int m, int n) {
		
		this.m = m;
		this.n = n;
		matrice = new int[m][n];
		inverse = new int[m][n];
		//matriceMultipliee = new int[m][n];
	}
	

		
	
	public void setValue() {
		System.out.println("Mettez les valeurs par lignes ! ");
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				System.out.print("Insérez un chiffre : ");
				value = scan.nextInt();
				matrice[i][j] = value;
				
			}
		}
		
		this.showValues();
		
	}
	
	//public void showValues() {
		// afficher le contenu du tableau matrice

		//for (int sousTab[] : matrice) { 
			//System.out.print("|");
			//for (int value : sousTab) {
				//System.out.print(value);
			//}
			//System.out.println("|");
		//}	
		
	//}
	
	


	public void multiplier () {
		
		System.out.println("Voulez-vous multiplier la matrice par un int ? (O/N)");
		
		if (reponse == "O") {
			
			System.out.println("Veuillez saisir un int.");
			multiplicateur = scan.nextInt();
			
			for (int i=0; i<m; i++) {
				for (int j=0; j<n; j++) {
					
					matriceMultipliee[i][j] = matrice[i][j]*multiplicateur;
				}
				
			}
			
			this.showValues2();	
			
		}
		
		else
			System.out.println("Au revoir !");
				
	}
	
	public void showValues2() {
		// afficher le contenu du tableau matrice

		for (int sousTab[] : matriceMultipliee) { 
			System.out.print("|");
			for (int value : sousTab) {
				System.out.print(value);
			}
			System.out.println("|");
		}	
		
	}
		
	
public void calculerInverse () {
		
		for (int sousTab[] : inverse) {
			
		}
		
		for (int sousTab[] : matrice) { 
			System.out.print("|");
			for (int value : sousTab) {
				System.out.print(value);
			}
			System.out.println("|");
		}	
		
	}
	
}