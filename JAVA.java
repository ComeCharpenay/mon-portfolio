package shifumiordi;

import java.util.Scanner;

/**
 * La classe principale pour le jeu Shifumi (pierre-feuille-ciseaux).
 * Ce programme ajoute un jeu contre l'ordinateur avec les règles classiques :
 * - le papier bat la pierre
 * - les ciseaux battent le papier
 * - la pierre bat les ciseaux
 * - Si deux éléments similaires : égalité
 *
 * @author come
 * @version 1.0
 */

public class Shifumipc {

    // variables
    int aleatoire;
    char choixJoueur;
    char choixOrdi;
    int ptOrdi;
    int ptJoueur;
    int round;
    boolean avecPuits;

	//étape 10
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shifumipc jeu = new Shifumipc();
        System.out.println("Voulez-vous jouer avec la version PUITS ? (O/N)");
        char reponsePuits = sc.next().toUpperCase().charAt(0);
        jeu.avecPuits = (reponsePuits == 'O');
        jeu.demarrer(sc);
    }

    public void demarrer(Scanner sc) {
        // Étape 1 : définir le nombre de points
        while (round != 3 && round != 5 && round != 10) {
            System.out.println("Combien souhaitez-vous de rounds ? (3, 5 ou 10)");
            round = sc.nextInt();

            if (round != 3 && round != 5 && round != 10) {
                System.out.println("La valeur entrée est incorrecte.");
            } else {
                System.out.println("Vous avez choisi : " + round + " rounds.");
            }
        }

        // Étape 6 : Boucle des manches
        for (int i = 1; i <= round; i++) {
            System.out.println("Manche " + i );

            // Étape 2 : Choix du joueur
            do {
                if (avecPuits) {
                    System.out.println("\nChoisissez un outil : P (pierre), F (feuille), C (ciseaux), Q (puits)");
                } else {
                    System.out.println("\nChoisissez un outil : P (pierre), F (feuille), C (ciseaux)");
                }
                choixJoueur = sc.next().toUpperCase().charAt(0);
                System.out.println("Vous avez choisi : " + symbole(choixJoueur));
            } while (choixJoueur != 'P' && choixJoueur != 'F' && choixJoueur != 'C' && (!avecPuits || choixJoueur != 'Q'));

            // Étape 3 : Choix aléatoire de l'ordinateur
            if (avecPuits) {									//option pour parties avec Puits
                aleatoire = (int)(Math.random() * 4) + 1;
            } else {
                aleatoire = (int)(Math.random() * 3) + 1;
            }

            if (aleatoire == 1) choixOrdi = 'P';
            else if (aleatoire == 2) choixOrdi = 'F';
            else if (aleatoire == 3) choixOrdi = 'C';
            else choixOrdi = 'Q';

            // Étape 4 : Révéler le choix après attente
            System.out.println("L'ordinateur réfléchit...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("L'ordinateur a choisi : " + symbole(choixOrdi));

            // Étape 5 : Déterminer le gagnant
            if (choixOrdi == choixJoueur) {
                System.out.println("Égalité !");
            } else if ((choixOrdi == 'P' && (choixJoueur == 'C')) ||
                       (choixOrdi == 'C' && (choixJoueur == 'F')) ||
                       (choixOrdi == 'F' && (choixJoueur == 'P')) ||
                       (choixOrdi == 'P' && choixJoueur == 'Q') ||
                       (choixOrdi == 'C' && choixJoueur == 'Q') ||
                       (choixOrdi == 'Q' && choixJoueur == 'F')) {
                ptOrdi++;
                System.out.println("L'ordinateur gagne la manche.");
            } else {
                ptJoueur++;
                System.out.println("Vous gagnez la manche !");
            }
        }

        // Étape 7 : Fin de partie
        System.out.println("Résultat final");
        System.out.println("Vous : " + ptJoueur + " | Ordinateur : " + ptOrdi);

        if (ptJoueur > ptOrdi) {
            System.out.println("Vous gagnez la partie !");
        } else if (ptJoueur < ptOrdi) {
            System.out.println("L'ordinateur a gagnez la partie !");
        } else {
            System.out.println("Égalité");
        }

        // Demander si l’utilisateur veut rejouer
        System.out.println("Voulez-vous rejouer ? (O/N)");
        char rejouer = sc.next().toUpperCase().charAt(0);
        if (rejouer == 'O') {
            ptJoueur = 0;
            ptOrdi = 0;
            round = 0;
            demarrer(sc);
        } else {
            System.out.println("Merci d'avoir joué !");
        }
    }

    // Étape 8 : Fonction utilitaire pour afficher les symboles
    public String symbole(char choix) {
        switch (choix) {
            case 'P': return "¤";
            case 'F': return "_";
            case 'C': return ">";
            case 'Q': return "O"; // symbole pour Puits
            default: return "erreur";
        }
    }
}


