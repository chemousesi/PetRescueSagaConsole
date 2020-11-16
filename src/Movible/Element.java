package Movible;

public abstract class Element {
    protected int score;
    protected Couleur couleur;

    Element(int score, Couleur couleur) {
        this.couleur = couleur;
        this.score = score;
    }
}
