package Movible;

public class Brique extends Element {

    Brique(int score, Couleur couleur) {
        super(score, couleur);
    }

    public boolean estMobile() {
        return true;
    }
}
