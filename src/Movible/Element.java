package Movible;

import java.io.Serializable;

public abstract class Element implements Serializable, Cloneable {
    protected int score;

    Element(int score) {
        this.score = score;
    }

    public boolean estMobile() {
        return true;
    }

}
