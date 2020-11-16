package Environnement;

import java.io.Serializable;

public class Conditions implements Serializable {
    private int nbAnimauxASauver;
    private int nbPointsAGagner;

    public Conditions(int nbAnimauxASauver, int nbPointsAGagner) {
        this.nbAnimauxASauver = nbAnimauxASauver;
        this.nbPointsAGagner = nbPointsAGagner;
    }
}
