package Environnement;

import java.io.Serializable;

public class Joueur implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String nom;
    private String nomUtilisateur;
    private int score;
    private int niveauActuel;

    public Joueur(String nom, String nomUser) {
        this.nom = nom;
        this.score = 0;
        this.niveauActuel = 2;
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

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    @Override
    public boolean equals(Object obj) {
        return this.nomUtilisateur.equals(((Joueur) obj).nomUtilisateur);
    }

    @Override
    public String toString() {
        return "Nom : " + this.nom + "\nNiveau Actuel : " + this.niveauActuel + "\nScore : " + this.score;
    }

}
