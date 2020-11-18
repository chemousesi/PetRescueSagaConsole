package Movible;

public class Obstacle extends Brique {

    public Obstacle(Couleur couleur) {
        super(0, couleur);
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
