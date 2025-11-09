//EXERCICE
//ECRIRE UN PROGRAMME PERMETTANT D'AFFICHER UN JEU DE BATAILLE NAVALE
// @author : Côme
// version 1.0
import java.util.Scanner;
public class TP5 {
	
	static void affichagetabJoueur(int tab[][], int nbcase) {
       System.out.println("  1 2 3 4 5");		//Affiche un espace avant la position des lignes
       for (int l = 0; l < nbcase; l++) {			// Parcours des lignes
           System.out.print((l+1) + " ");		//Afficher la ligne plus un espace 
           for (int l2 = 0; l2 < nbcase; l2++) {	// Parcours des colonnes
               if (tab[l][l2] == 1) {
				   System.out.print("o ");
			   } else {
				   System.out.print("~ ");
			   }
		   }
           System.out.println(); 					// retour à la ligne après chaque rangée
       }
	}
	
	static void affichageAvecEtats(int tab[][], int nbcase) {
        System.out.println("  1 2 3 4 5");  // Affiche un espace avant la position des lignes
        for (int l = 0; l < nbcase; l++) {  		// Parcours des lignes
            System.out.print((l+1) + " ");  // Affiche le numéro de la ligne
            for (int l2 = 0; l2 < nbcase; l2++) {   // Parcours des colonnes
                switch (tab[l][l2]) {
                    case 0:  					// Cas avec aucun pion sur la case
                    case 1:  					// Cas avec une case non découvert
                        System.out.print("? ");
                        break;
                    case 2:						// Cas avec un pion découvert
                        System.out.print("o ");
                        break;
                    case 3:  					// Cas avec une case découverte sans pion
                        System.out.print("x ");
                        break;
                    default:
                        System.out.print("~ ");  // Cas par défaut
                }
            }
            System.out.println();  // Retour à la ligne
        }
    }
	
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int tabjoueur[][] = new int [5][5];
			int tabordi[][] = new int [5][5];
			
		int i = 1; //initialisation de i
		
		while(i<=5){ // boucle pour i de 1 à 5
		System.out.println("Sur quelle ligne voulez vous placez votre pion (0-4)");
		int ligne = sc.nextInt();
		System.out.println("Sur quelle colonne voulez vous placez votre pion (0-4)");
		int colonne = sc.nextInt();
		
		 // Vérification si la case est déjà occupée
       if (tabjoueur[ligne][colonne] != 0) {
           System.out.println("Cette case est déjà occupée! Choisissez en une autre");
           continue;  // Si la case est occupée, on recommence le tour
       }
       tabjoueur[ligne][colonne] = 1;
       System.out.println("Vous avez placé votre pion n°" + i + " à la position " + ligne + ", " + colonne );
       ++i; // Ajouter +1 à i pour recommencer la boucle
		}
      
		affichagetabJoueur(tabjoueur, 5);
		
		
      
       int i2 = 1; //initialisation de i
      
       while(i2<=5){ // boucle pour i de 1 à 5
       int ligneordi = (int)(Math.random()*5);
       int colonneordi = (int)(Math.random()*5);
    
    
    // Vérification si la case est déjà occupée
       if (tabordi[ligneordi][colonneordi] != 0) {
           continue;  // Si la case est occupée, on recommence le tour
       }
       tabordi[ligneordi][colonneordi] = 1;
       System.out.println("L'ordinateur a placé son pion n°" + i2 + " à la position " + ligneordi + ", " + colonneordi ); // a enlever apes test
       ++i2; // Ajouter +1 à i pour recommencer la boucle
       }
	   
	   
	   
	   int pionTrouve = 0; 	// compteur de pions touchés
			System.out.println(" A vous de jouer !");
			System.out.println("Sur quelle ligne voulez-vous découvrir une case (0-4) ?");
			int ligneTir = sc.nextInt();
			System.out.println("Sur quelle colonne voulez-vous découvrir une case (0-4) ?");
			int colonneTir = sc.nextInt();
			
			System.out.println("Tir en cours");
			Thread.sleep(2000); // pause de 2 secondes
			
			// Vérification du résultat du tir
			if(tabordi[ligneTir][colonneTir] == 0) {
				System.out.println("Raté !");
				tabordi[ligneTir][colonneTir] = 3; // case découverte sans pion
			} else if(tabordi[ligneTir][colonneTir] == 1) {
				System.out.println("Touché !");
				tabordi[ligneTir][colonneTir] = 2; // pion découvert
				pionTrouve++;
			} else {
				System.out.println("Tir à blanc !");
			}
			
			// Affichage du plateau ordinateur après le tir
			System.out.println("Tableau de l'ordinateur après le tir :");
			affichageAvecEtats(tabordi, 5);
		}
}
}
}
