package Movible;

public class Brique extends Element {
    protected Couleur couleur;

    Brique(int score, Couleur couleur) {
        super(score);
        couleur = couleur;
    }

    public boolean estMobile() {
        return true;
    }

    @Override
    public String toString() {
        return couleur.toString();
    }
}
