package Movible;

public class Obstacle extends Brique {

    Obstacle(double score, Couleur couleur) {
        super(score, couleur);
        // TODO Auto-generated constructor stub
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
