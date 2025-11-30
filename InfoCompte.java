// EXERCICE
// ECRIRE UN PROGRAMME OBJET
// @author : Côme
// version 1.0


import java.util.Scanner;

public class InfoCompte {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Création Client : ");
        System.out.print("CIN : ");
        String cin = sc.nextLine();
        System.out.print("Nom : ");
        String nom = sc.nextLine();
        System.out.print("Prénom : ");
        String prenom = sc.nextLine();
        System.out.print("Téléphone : ");
        String tel = sc.nextLine();

        Client client1 = new Client(cin, nom, prenom, tel);

        Compte compte1 = new Compte(client1);

        System.out.print("Montant à déposer : ");
        double depot = sc.nextDouble();
        compte1.crediter(depot);

        System.out.print("Montant à retirer : ");
        double retirer = sc.nextDouble();
        compte1.debiter(retirer);

        compte1.afficher();

        sc.close();
    }
}
