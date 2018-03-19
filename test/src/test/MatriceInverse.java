package test;


public class MatriceInverse {
	
	int m, n, value; // m = nbre de lignes et n = nbre de colonnes
	int[][] matrice;
	
	
	public MatriceInverse(int m, int n) {
		this.m = m;
		this.n = n;
		matrice = new int[m][n];
		
		// Instantiation des 1 et des 0
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				
				if (i==j) {
					matrice[i][j] = 1;
				} else {
					matrice[i][j] = 0;
				}
							
			}
		}
		
		
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
	
	
	
	
	
}
