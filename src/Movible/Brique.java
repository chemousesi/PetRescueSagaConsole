package Movible;

public class Brique extends Element {
    private Couleur couleur;

    public Brique(int score, Couleur couleur) {
        super(score);
        this.couleur = couleur;
    }

    public boolean estMobile() {
        return true;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        return couleur.toString();
    }
}
