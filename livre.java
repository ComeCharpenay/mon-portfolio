// EXERCICE
// ECRIRE UN PROGRAMME OBJET
// @author : Côme
// version 1.0


public class Livre {

    private String titre;
    private String auteur;
    private int prix;

    // Constructeur
    public Livre(String titre, String auteur, int prix) {
        this.titre = titre;
        this.auteur = auteur;
        this.prix = prix;
    }

    // Méthode Afficher()
    public void afficher() {
        System.out.println("Titre : " + titre);
        System.out.println("Auteur : " + auteur);
        System.out.println("Prix : " + prix);
    }
}
