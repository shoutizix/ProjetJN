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
			System.out.println("La matrice n'est pas carrée ! ");
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
		System.out.println("Multipliï¿½e par : "+multiplicateur);
		matriceMultipliee.showValues();
		
	}
	
public void multiplierParMatrice(Matrice matrice2) {
	int v =0;
		Matrice matriceMultipliee = new Matrice(this.m,matrice2.n);
		for (int i=0; i<m; i++) {
			for (int j=0; j<matrice2.n; j++) {
				
				for (int x=0;x<n;x++) {
					v+=matrice[i][x]*matrice2.matrice[x][j];
				}
				
				matriceMultipliee.matrice[i][j]=v;
				v=0;
			}
		}
		System.out.println("Matrice de base : ");
		this.showValues();
		System.out.println("Multipliï¿½e par : ");
		matrice2.showValues();
		System.out.println("Correspond à : ");
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
				System.out.print("InsÃ©rez un chiffre : ");
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
		System.out.println("La matrice n'est pas carrï¿½e ! ");
	}
	
	
	}



}