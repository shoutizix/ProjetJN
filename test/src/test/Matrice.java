package test;

import java.util.Random;
import java.util.Scanner;

import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

public class Matrice {
	
	int m, n; // m = nbre de lignes et n = nbre de colonnes
	double value; 
	double[][] matrice;
	Scanner scan = new Scanner(System.in);
	
	public Matrice (int m, int n) {
		
		this.m = m;
		this.n = n;
		matrice = new double[m][n];
		
		
	}
	
	public void changerDimension(int m,int n) {
		this.m = m;
		this.n= n;
		matrice = new double[m][n];
	}
	
	public String multiplierParInt(int multiplicateur) {
		
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
		return matriceMultipliee.showValues();
		
	}
	
public String multiplierParMatrice(Matrice matrice2) {

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
		
		return matriceMultipliee.showValues();
	}
	
		
	public void valeurParDefaut() {
		//Rempli la matrice de 1
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				matrice[i][j] = 1;		
			}
		}
	}
	
	public void randomValues() {
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				Random random = new Random();
				matrice[i][j] = random.nextInt(9);			
			}
		}
	}
	
	public void setValue() {
		System.out.println("Mettez les valeurs par lignes ! ");
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				System.out.print("Ins�rez un chiffre � la position ("+i+";"+j+") : ");
				//value = scan.nextInt();
				//matriceM.matrice[i][j] = value;
			}
		}
		
		this.showValues();
		
	}
	
	public void setValueAt(int i, int j, int value) {
		matrice[i][j] = value;
	}
	
	public String showValues() {
		 //afficher le contenu du tableau matrice
		String texte = "";
		for (double sousTab[] : matrice) { 
			System.out.print("| ");
			texte += "| ";
			for (double value : sousTab) {
				Fraction f = new Fraction(value);
				System.out.print(f.toString()+" ");
				if (f.getDenominator()==1) {
					texte += f.toString()+" ";
				} else {
					texte += f.getNumerator()+"/"+f.getDenominator()+" ";
				}
			}
			System.out.println("|");
			texte += "| \n";
		}	
		return texte;
	}
	
		
	
public String calculerInverse () {
		
		RealMatrix matriX = MatrixUtils.createRealMatrix(matrice);
		RealMatrix matriXInverse = new LUDecomposition(matriX).getSolver().getInverse();
		Matrice matriceInverse = new Matrice(matriXInverse.getRowDimension(), matriXInverse.getColumnDimension());
		matriceInverse.matrice = matriXInverse.getData();
		return matriceInverse.showValues();
	}




}