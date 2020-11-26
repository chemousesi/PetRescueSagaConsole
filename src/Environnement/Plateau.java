package Environnement;

import java.io.Serializable;
import Movible.*;

public class Plateau implements Serializable {
    int lignes;
    int colonnes;
    private Case cases[][];

    public Plateau(Case[][] cases) {
        this.cases = cases;
        lignes = cases.length;
        colonnes = cases[0].length;
    }

    public Plateau(int l, int c) {
        lignes = l;
        colonnes = c;
        cases = new Case[l][c];
        // initialiserPlateau();
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
        System.out.println(lignes + " lignes et " + colonnes + " colonnes");
        for (int l = 0; l < this.cases.length; l++) {
            for (int c = 0; c < this.cases[0].length; c++) {
                System.out.print(cases[l][c] + " ");
            }
            System.out.println();
        }
    }

    public static Case[][] plateauNiveau1() {
        Case[][] cases1 = {
                { new Case(new Brique(10, Couleur.violet), true), new Case(new Animal(20, "Chat", ""), true),
                        new Case(new Brique(10, Couleur.rouge), true), new Case(null, false), },
                { new Case(new Brique(10, Couleur.violet), true), new Case(new Brique(10, Couleur.jaune), true),
                        new Case(new Brique(10, Couleur.rouge), true), new Case(new Animal(20, "Chien", ""), true), },
                { new Case(new Brique(10, Couleur.violet), true), new Case(new Brique(10, Couleur.jaune), true),
                        new Case(new Brique(10, Couleur.rouge), true), new Case(new Brique(10, Couleur.rouge), true), },
                { new Case(new Brique(10, Couleur.violet), true), new Case(new Brique(10, Couleur.violet), true),
                        new Case(new Brique(10, Couleur.bleu), true), new Case(new Brique(10, Couleur.bleu), true), },
                { new Case(new Brique(10, Couleur.violet), true), new Case(new Brique(10, Couleur.bleu), true),
                        new Case(new Brique(10, Couleur.bleu), true), new Case(new Brique(10, Couleur.bleu), true), } };

        return cases1;
    }

    public void detruireBrique(int l, int c, int acc) {

        if (l >= lignes || l < 0 || c >= colonnes || c < 0) {
            System.out.println("mauvaise selection des indices ");
            return;
        } else if (!cases[l][c].isActive()) {
            System.out.println("Case hors de jeu");
            return;
        } else if (!(cases[l][c].getElement() instanceof Brique))
            return;

        if (acc > 1) {
            cases[l][c].vider();
        }

        Couleur couleurCible = ((Brique) cases[l][c].getElement()).getCouleur();

        if (((Brique) cases[l][c + 1].getElement()).getCouleur() == couleurCible) {
            detruireBrique(l, c + 1, acc + 1);
        }
        if (((Brique) cases[l][c - 1].getElement()).getCouleur() == couleurCible) {
            detruireBrique(l, c - 1, acc + 1);
        }
        if (((Brique) cases[l + 1][c].getElement()).getCouleur() == couleurCible) {
            detruireBrique(l + 1, c, acc + 1);
        }
        if (((Brique) cases[l - 1][c].getElement()).getCouleur() == couleurCible) {
            detruireBrique(l - 1, c, acc + 1);
        }

    }

    public int detruireBriqueAux(int l, int c, Couleur couleur, int acc)
    // acc c'est pour calculer le score qui se multiplie par 2 à chaque fois nous
    // détruisons une brique
    {

        if (l >= lignes || l < 0 || c >= colonnes || c < 0) {
            // System.out.println("mauvaise selection des indices ");
            return acc;
        } else if (!cases[l][c].isActive()) {
            // System.out.println("Case hors de jeu");
            return acc;

        } else if (cases[l][c].estVide()) {
            // System.out.println("case vide");
            return acc;

        } else if (!(cases[l][c].estUneBrique()))
            return acc;

        if ((cases[l][c].getBrique().getCouleur() == couleur)) {
            cases[l][c].vider();
            acc = acc * 2;
        } else
            return acc;

        acc = detruireBriqueAux(l, c + 1, couleur, acc);
        acc = detruireBriqueAux(l, c - 1, couleur, acc);
        acc = detruireBriqueAux(l + 1, c, couleur, acc);
        acc = detruireBriqueAux(l - 1, c, couleur, acc);
        return acc;
    }

    public boolean briqueMmCouleuraAdj(int l, int c) {
        // retourne le nombre de brique adjaçantes qui ont la meme couleure que la
        // brique selectionnée
        if (!cases[l][c].estUneBrique())
            return false;
        Couleur coul = cases[l][c].getBrique().getCouleur();

        if (cases[l - 1][c].estUneBrique() && cases[l - 1][c].getBrique().getCouleur() == coul
                || cases[l + 1][c].estUneBrique() && cases[l + 1][c].getBrique().getCouleur() == coul
                || cases[l][c - 1].estUneBrique() && cases[l][c - 1].getBrique().getCouleur() == coul
                || cases[l][c + 1].estUneBrique() && cases[l][c + 1].getBrique().getCouleur() == coul) {
            return true;
        }

        return false;

    }

    public int detruire(int l, int c) {
        int score = 0;
        if (cases[l][c].estUneBrique()) {
            System.out.println("Couleur selectionée est " + cases[l][c].getBrique().getCouleur());
            score = detruireBriqueAux(l, c, cases[l][c].getBrique().getCouleur(), 1);
        } else {
            System.out.println("ce n'est pas une brique");
            return 0;
        }
        return score;
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
