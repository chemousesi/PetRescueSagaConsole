package Environnement;

import java.io.Serializable;
import Movible.*;

public class Plateau implements Serializable {
    private Case cases[][];
    private int lignes;
    private int colonnes;

    public Plateau(Case[][] cases) {
        this.cases = cases;
        lignes = 3;
        colonnes = 5;
    }

    public Plateau(int l, int c) {
        lignes = l;
        colonnes = c;
        cases = new Case[l][c];
        initialiserPlateau();
    }

    public Case getCase(int l, int c) {
        // il faut rajouter la condition de ne pas dépasser les limites du plateau
        return cases[l][c];
    }

    public void initialiserPlateau() {
        for (int l = 0; l < lignes; l++) {
            for (int c = 0; c < colonnes; c++) {
                cases[l][c] = new Case();
            }
        }
    }

    public void afficher() {
        for (int l = 0; l < lignes; l++) {
            for (int c = 0; c < colonnes; c++) {
                System.out.print(cases[l][c] + " ");
            }
            System.out.println();
        }
    }

}
