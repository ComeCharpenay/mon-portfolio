// EXERCICE
// ECRIRE UN PROGRAMME OBJET
// @author : Côme
// version 1.0


import java.util.Scanner;
public class TP7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Livre 1
        System.out.println("Livre 1 :");
        System.out.print("Donner le titre : ");
        String titre1 = sc.nextLine();
        System.out.print("Donner l'auteur : ");
        String auteur1 = sc.nextLine();
        System.out.print("Donner le prix : ");
        int prix1 = sc.nextInt();
        sc.nextLine();

        Livre livre1 = new Livre(titre1, auteur1, prix1);
        livre1.afficher();

        // Livre 2
        System.out.println("\nLivre 2 :");
        System.out.print("Donner le titre : ");
        String titre2 = sc.nextLine();
        System.out.print("Donner l'auteur : ");
        String auteur2 = sc.nextLine();
        System.out.print("Donner le prix : ");
        int prix2 = sc.nextInt();

        Livre livre2 = new Livre(titre2, auteur2, prix2);
        livre2.afficher();

        sc.close();
    }
}
