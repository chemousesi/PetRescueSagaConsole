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

    public void reorganiserPlateau() throws CloneNotSupportedException {
        boolean terminer = false;
        boolean obstacleColonne;
        boolean arreter;
        int i = 1; /// pour les colonnes
        int j = cases.length - 2; /// pour les lignes
        int switcher, nbCasesActivesVidesColonnes;
        while (!terminer) {
            if (cases[j][i].estVide() && cases[j][i].isActive()) {
                switcher = j;
                j--;
                obstacleColonne = false;
                nbCasesActivesVidesColonnes = 0;
                while (!obstacleColonne && j > 0) {
                    if (!cases[j][i].estVide()) {
                        if (cases[j][i].getElement().estMobile()) {
                            cases[switcher][i] = (Case) cases[j][i].clone();
                            cases[j][i].vider();
                            switcher--;
                        } else /// ajouter un traitement aprés.
                            obstacleColonne = true;
                    } else if (cases[j][i].isActive())
                        nbCasesActivesVidesColonnes++;
                    j--;
                }
                i++;
                j = cases.length - 2;
                if (i > cases[0].length - 2) {
                    terminer = true;
                } else {
                    if (nbCasesActivesVidesColonnes == cases.length - 2) {
                        switcher = j;
                        arreter = false;
                        while (!arreter) {
                            if (cases[switcher][i - 1].estVide()) {
                                if (!cases[j][i].estVide()) {
                                    if (cases[j][i].getElement().estMobile()) {
                                        cases[switcher][i - 1] = (Case) cases[j][i].clone();
                                        cases[j][i].vider();
                                        j--;
                                        switcher--;
                                    } else {
                                        arreter = true;
                                    }
                                } else
                                    j--;
                            }
                        }
                    }
                }
            }
        }
    }
}
