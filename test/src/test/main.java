package test;

import java.util.Scanner;

public class main {
	
	static int nbreligne;
	static int nbrecolonne;
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		//Fenetre f = new Fenetre();
		System.out.println("Combien de ligne y a-t-il dans la matrice ? ");
		nbreligne = scan.nextInt();
		System.out.println("Combien de colonne y a-t-il dans la matrice ? ");
		nbrecolonne = scan.nextInt();
		
		Matrice matrice = new Matrice(nbreligne,nbrecolonne);
		matrice.setValue();
	}

}
