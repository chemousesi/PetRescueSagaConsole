package Environnement;

import java.io.Serializable;
import java.util.ArrayList;
import Movible.*;

public class Plateau implements Serializable {
    private Case cases[][];

    public Plateau() {
        cases = new Case[10][10];
    }

    public void initialiserPlateau() {
        // cette méthode va remplir le plateau avec des briques, des obstaclles et des
        // animaux, et aussi,
    }

    public Case getCase(int l, int c) {
        // il faut rajouter la condition de ne pas dépasser les limites du plateau
        return cases[l][c];
    }

}
