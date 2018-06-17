package test;

import java.util.Scanner;

public class AlgoSimplex {
	
	Scanner scan = new Scanner(System.in);
	int [][] X; // Dimension 0 = Z, 1 = Contrainte1, 2 = Contrainte2, etc...
	int nbreContraintes;
	int nbreX;
	
	public AlgoSimplex(int nbreContraintes, int nbreX) {
		
		this.nbreContraintes = nbreContraintes;
		this.nbreX = nbreX;
		X = new int[nbreContraintes+1][nbreX+nbreContraintes]; 
		
		for (int i=0; i<nbreX; i++) {
			System.out.println("Que vaut x"+(i+1)+" dans Z ?");
			X[0][i] = scan.nextInt();	
		}
		
		for (int i=1; i<nbreContraintes+1; i++) {
			for (int j=0; j<nbreX; j++) {
				System.out.println("Dans la contrainte : "+(i)+" que vaut x"+(j+1)+"?");
				X[i][j] = scan.nextInt();
			}
			
		}
		
		for (int i=0; i<nbreContraintes+1; i++) {
			for (int j=nbreX; j<nbreX+nbreContraintes; j++) {		
				if (j-i+1==nbreX) {
					X[i][j] = 1;
				} else {
					X[i][j] = 0;
				}								
			}
		}
		
	}
	
	public void showStandardForm () {
		
		for (int sousTab[] : X) { 
			System.out.print("| ");
			for (int value : sousTab) {
				System.out.print(value+" ");
			}
			System.out.println("|");
		}	
		
	}
	
	public int premierDantzig() {
		int position = 0;
		for (int i=0; i<nbreX; i++) {
			if (X[0][i]<0) {
				position = i;
			}
			
		}
		return position;
	}
	
}
