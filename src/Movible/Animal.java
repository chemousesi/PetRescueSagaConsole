package Movible;

public class Animal extends Element {
    private String nom;
    private String icon;

    public Animal(int score, String nom, String icon) {
        super(score);
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
        // return Character.toString(nom.charAt(0)).toUpperCase();
        return "$";
    }

}
// ajouter des animaux comme sous classes