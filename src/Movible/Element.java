package Movible;

import java.io.Serializable;

public abstract class Element implements Serializable {
    protected int score;
    protected Couleur couleur;

    Element(Couleur couleur) {
        this.couleur = couleur;

    }

    Element(int score, Couleur couleur) {
        this.couleur = couleur;
        this.score = score;
    }

    public boolean estMobile() {
        return true;
    }
}
