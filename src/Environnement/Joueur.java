package Environnement;

public class Joueur {
    private String nom;
    private String nomUtilisateur;
    private int score;
    private int niveauActuel;

    public Joueur(String nom, String nomUser) {
        this.nom = nom;
        this.score = 0;
        this.niveauActuel = 0;
        this.nomUtilisateur = nomUser;
    }

    public void setniveauActuel(int niveauActuel) {
        this.niveauActuel = niveauActuel;
    }

    public void incrementerNivActuel() {
        this.niveauActuel++;
    }

    public String getnom() {
        return nom;
    }

    public int getScore() {
        return score;
    }

    public int getniveauActuel() {
        return niveauActuel;
    }

}
