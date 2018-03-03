package test;

import java.util.Scanner;

public class Matrice {
	
	int m, n, value; // m = nbre de lignes et n = nbre de colonnes
	int[][] matrice;
	Scanner scan = new Scanner(System.in);
	
	
	public Matrice (int m, int n) {
		this.m = m;
		this.n = n;
		matrice = new int[m][n];
		
		
	}
	
	public void setValue() {
		System.out.print("Mettez les valeurs par lignes ! ");
		for (int i=0; i<m; i++) {
			System.out.print("Insérez un chiffre : ");
			value = scan.nextInt();
			matrice[0][i] = value;
		}
		
		// afficher le contenu du tableau matrice
		for (int sousTab[] : matrice) { 
			
			for (int value : sousTab) {
				System.out.print(value);
			}
			
		}
		
		
	}
	
	
	
	
	
	
}