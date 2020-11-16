package Movible;

public class Obstacle extends Element {

    Obstacle(Couleur couleur) {
        super(couleur);
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
