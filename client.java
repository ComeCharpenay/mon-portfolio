// EXERCICE
// ECRIRE UN PROGRAMME OBJET
// @author : Côme
// version 1.0


public class Client {
    private String CIN;
    private String nom;
    private String prenom;
    private String telephone;

    public Client(String CIN, String nom, String prenom, String telephone) {
        this.CIN = CIN;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }
	
    public void afficher() {
        System.out.println("CIN : " + CIN);
        System.out.println("Nom : " + nom);
        System.out.println("Prénom : " + prenom);
        System.out.println("Tel : " + telephone);
    }
}
