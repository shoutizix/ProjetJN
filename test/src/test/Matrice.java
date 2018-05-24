package test;

import java.util.Scanner;

import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

public class Matrice {
	
	int m, n; 
	double value; // m = nbre de lignes et n = nbre de colonnes
	double[][] matrice;
	Scanner scan = new Scanner(System.in);
	
	public Matrice (int m, int n) {
		
		this.m = m;
		this.n = n;
		matrice = new double[m][n];
		
		RealMatrix matriX = MatrixUtils.createRealMatrix(matrice);
		
		
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

		System.out.println("Matrice de base : ");
		this.showValues();
		RealMatrix matriX = MatrixUtils.createRealMatrix(this.matrice);
		System.out.println("Multipli�e par : ");
		matrice2.showValues();
		RealMatrix matriX2 = MatrixUtils.createRealMatrix(matrice2.matrice);
		System.out.println("Correspond � : ");
		RealMatrix matriXMultipliee = matriX.multiply(matriX2);
		Matrice matriceMultipliee = new Matrice(matriXMultipliee.getRowDimension(), matriXMultipliee.getColumnDimension());
		matriceMultipliee.matrice = matriXMultipliee.getData();
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
		
		RealMatrix matriX = MatrixUtils.createRealMatrix(matrice);
		
		this.showValues();
		
	}
	
	public void showValues() {
		 //afficher le contenu du tableau matrice

		for (double sousTab[] : matrice) { 
			System.out.print("| ");
			for (double value : sousTab) {
				value = arrondi(value,1);
				System.out.print(value+" ");
			}
			System.out.println("|");
		}	
		
	}
	
		
	
public void calculerInverse () {
		
		RealMatrix matriX = MatrixUtils.createRealMatrix(matrice);
		RealMatrix matriXInverse = new LUDecomposition(matriX).getSolver().getInverse();
		Matrice matriceInverse = new Matrice(matriXInverse.getRowDimension(), matriXInverse.getColumnDimension());
		matriceInverse.matrice = matriXInverse.getData();
		matriceInverse.showValues();
	}

private static double arrondi (double valeur, int precision) {
    int scale = (int) Math.pow(10, precision);
    return (double) Math.round(valeur * scale) / scale;
}



}