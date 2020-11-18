package Environnement;

import java.io.Serializable;
import Movible.*;

public class Plateau implements Serializable {
    private Case cases[][];

    public Plateau(Case[][] cases) {
        this.cases = cases;
    }

    public Case getCase(int l, int c) {
        // il faut rajouter la condition de ne pas dépasser les limites du plateau
        return cases[l][c];
    }

    // public void initialiserPlateau() {
    // for (int l = 0; l < lignes; l++) {
    // for (int c = 0; c < colonnes; c++) {
    // cases[l][c] = new Case();
    // }
    // }
    // }

    public void afficher() {
        for (int l = 0; l < this.cases.length; l++) {
            for (int c = 0; c < this.cases[0].length; c++) {
                System.out.print(cases[l][c] + " ");
            }
            System.out.println();
        }
    }

}
