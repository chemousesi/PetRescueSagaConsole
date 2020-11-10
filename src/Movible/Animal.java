package Movible;

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

}
