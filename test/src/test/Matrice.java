package test;

import java.util.Scanner;

public class Matrice {
	
	int m, n, value; // m = nbre de lignes et n = nbre de colonnes
	int[][] matrice;
	private boolean inverseExiste = false;
	MatriceInverse inverse;
	Scanner scan = new Scanner(System.in);
	
	public Matrice (int m, int n) {
		
		this.m = m;
		this.n = n;
		matrice = new int[m][n];
		if (m==n) {
			inverse = new MatriceInverse(m,n);
			inverseExiste = true;
		} else {
			System.out.println("La matrice n'est pas carr�e ! ");
		}
		//inverse = new int[m][n];
		
	}
	
	public void multiplierParInt(int multiplicateur) {
		
		Matrice matriceMultipliee = new Matrice(this.m,this.n);
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				value = this.matrice[i][j]*multiplicateur;
				matriceMultipliee.matrice[i][j] = value;
			}
		}
		System.out.println("Matrice de base : ");
		this.showValues();
		System.out.println("Multipli�e par : "+multiplicateur);
		matriceMultipliee.showValues();
		
	}
	
public void multiplierParMatrice(Matrice matrice2) {
		
		Matrice matriceMultipliee = new Matrice(this.m,this.n);
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				value = this.matrice[i][j]*matrice2.matrice[i][j];
				matriceMultipliee.matrice[i][j] = value;
			}
		}
		System.out.println("Matrice de base : ");
		this.showValues();
		System.out.println("Multipli�e par : ");
		matriceMultipliee.showValues();
		
	}
	
		
	public void valeurParDefaut() {
		//Rempli la matrice de 1
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				matrice[i][j] = 1;		
			}
		}
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
	
	public void showValues() {
		 //afficher le contenu du tableau matrice

		for (int sousTab[] : matrice) { 
			System.out.print("| ");
			for (int value : sousTab) {
				System.out.print(value+" ");
			}
			System.out.println("|");
		}	
		
	}
	
		
	
public void calculerInverse () {
		
		//for (int sousTab[] : inverse) {
			
		//}
		
		for (int sousTab[] : matrice) { 
			System.out.print("|");
			for (int value : sousTab) {
				System.out.print(value);
			}
			System.out.println("|");
		}	
		
	}


public void showInverse() {
	
	//afficher le contenu de la matrice inverse
	if (inverseExiste) {
		inverse.showValues();
	} else {
		System.out.println("La matrice n'est pas carr�e ! ");
	}
	
	
	}



}