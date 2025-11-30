// EXERCICE
// ECRIRE UN PROGRAMME OBJET
// @author : Côme
// version 1.0


public class Compte {
    private static int compteur = 0;

    private int numero;
    private double solde;
    private Client proprietaire;

    public Compte(Client proprietaire) {
        compteur++;
        this.numero = compteur;
        this.solde = 0;
        this.proprietaire = proprietaire;
    }

    public void crediter(double montant) {
        solde = solde + montant;
    }

    public void debiter(double montant) {
        solde = solde - montant;
    }

    public void virement(Compte autre, double montant) {
        this.debiter(montant);
        autre.crediter(montant);
    }

    public void afficher() {
        System.out.println("Numéro de compte : " + numero);
        System.out.println("Solde : " + solde);
        System.out.println("Propriétaire : ");
        proprietaire.afficher();
    }
}
