package Movible;

import Movible.Couleur;

public class Animal extends Case {
    private String nom;
    private String icon;

    public Animal(double score, Couleur couleur, String nom, String icon, int valeur) {
        super(score, couleur);
        this.nom = nom;
        this.icon = icon;
    }

    public String getNom() {
        return nom;
    }

    public String getIcon() {
        return icon;
    }

    @Override
    public String toString() {
        return Character.toString(nom.charAt(0)).toUpperCase();
    }

}
// ajouter des animaux comme sous classes 