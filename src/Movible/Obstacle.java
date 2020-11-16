package Movible;

public class Obstacle extends Brique {
    private String icon;/// pour la partie graphique.

    Obstacle(int score, Couleur couleur) {
        super(score, couleur);
    }

    @Override
    public boolean estMobile() {
        return false;
    }

    @Override
    public String toString() {
        return "\u0800";
    }

}
