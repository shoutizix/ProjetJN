package test;

import java.util.Scanner;

import org.apache.commons.math3.fraction.Fraction;

public class AlgoSimplex {
	
	Scanner scan = new Scanner(System.in);
	double [][] X; // Dimension 0 = Z, 1 = Contrainte1, 2 = Contrainte2, etc...
	int nbreContraintes;
	int nbreX;
	
	public AlgoSimplex(int nbreContraintes, int nbreX) {
		
		this.nbreContraintes = nbreContraintes;
		this.nbreX = nbreX;
		X = new double[nbreContraintes+1][nbreX+nbreContraintes+1]; 
		
		for (int i=0; i<nbreX; i++) {
			System.out.println("Que vaut x"+(i+1)+" dans Z ?");
			X[0][i] = scan.nextInt();	
		}
		
		for (int i=1; i<nbreContraintes+1; i++) {
			for (int j=0; j<nbreX; j++) {
				System.out.println("Dans la contrainte : "+(i)+" que vaut x"+(j+1)+"?");
				X[i][j] = scan.nextInt();
			}
			System.out.println("Dans la contrainte : "+(i)+" à quelle valeur doit être superieur x?");
			X[i][nbreX+nbreContraintes] = scan.nextInt();
		}
		
	}
	
	public AlgoSimplex(double[][] tableau) {
		
		this.X = tableau;
		this.nbreX = 2;
		this.nbreContraintes = 2;
		
	}
	
	public void showStandardForm () {
		for (int i=0; i<nbreContraintes+1; i++) {
			for (int j=nbreX; j<nbreX+nbreContraintes; j++) {		
				if (j-i+1==nbreX) {
					X[i][j] = 1;
				} else {
					X[i][j] = 0;
				}								
			}
		}
		System.out.print("Z = ");
		for (double sousTab[] : X) { 
			System.out.print("| ");
			for (double value : sousTab) {
				System.out.print(value+" ");
			}
			System.out.println("|");
		}	
		
	}
	
	
	public boolean deuxiemeCDantzigBool() {
		boolean possible = false;
		for (int i=1; i<=nbreX; i++) {
			if (X[0][i]<0) {
				possible = true;
			}
			
		}
		return possible;
	}
	
	public double deuxiemeCDantzig() {
		int position = 0;
		for (int i=1; i<=nbreX; i++) {
			if (X[0][i]<X[0][position]) {
				position = i;
			}
			
		}
		return X[0][position];
	}
	
	public int deuxiemeCDantzigPos() {
		int positionC = 0;
		for (int i=1; i<=nbreX; i++) {
			if (X[0][i]<X[0][positionC]) {
				positionC = i;
			}
			
		}
		return positionC;
	}
	
	public double premierCDantzig(int colonne) {
		int position = 0;
		for (int i=1; i<=nbreX; i++) {
			if (X[i][colonne]>0) {
				double v = X[i][0]/X[i][colonne];
				if(position!=0) {
					if (v<X[position][0]/X[position][colonne]) {
						position = i;
					}
				} else {
				position = i;
				}
			}
			
		}
		return X[position][colonne];
	}
	
	public boolean premierCDantzigBool(int colonne) {
		boolean possible = false;
		if (deuxiemeCDantzigBool()) {
			for (int i=1; i<=nbreX; i++) {
				if (X[i][colonne]>0) {
					possible = true;
				}
			}
		}
		return possible;
	}
	
	public int premierCDantzigPos(int colonne) {
		int positionL = 0;
		for (int i=1; i<=nbreX; i++) {
			if (X[i][colonne]>0) {
				double v = X[i][0]/X[i][colonne];
				if(positionL!=0) {
					if (v<X[positionL][0]/X[positionL][colonne]) {
						positionL = i;
					}
				} else {
				positionL = i;
				}
			}
			
		}
		return positionL;
	}
	
	public void pivoter(int c, int l) {
		
		//ligne du pivot
		for (int i=0; i<=nbreX; i++) {
			if (i==c) {
								
			} else {
				X[l][i] = X[l][i]/X[l][c];
			}
			 
		}
		//reste des valeurs
		for (int i=0; i<=nbreX; i++) {
			for (int j=0; j<=nbreContraintes; j++) {
				if (j==c||i==l) {
					
				} else {
					X[i][j] = X[i][j]-(X[l][j]*X[i][c]);							
				}
			}
		}
		//colonne du pivot
		for (int i=0; i<=nbreX; i++) {
			if (i==l) {
								
			} else {
				X[i][c] = -1*(X[i][c]/X[l][c]);
			}
			 
		}
		//pivot
		X[l][c] = 1/X[l][c];
				
	}
	
	public String getValueAt(int l, int c) {
		double value = X[l][c];
		//Fraction f = new Fraction(value);
		String texte = "" +value;
		return texte;
	}
	
}
