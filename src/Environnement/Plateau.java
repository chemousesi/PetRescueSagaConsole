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

<<<<<<< HEAD
    public void initialiserPlateau() {
        for (int l = 0; l < lignes - 1; l++) {
            for (int c = 0; c < colonnes - 1; c++) {
                cases[l][c] = new Case();
            }
        }
    }

    public void afficher() {
        for (int l = 1; l < lignes - 1; l++) {
            for (int c = 1; c < colonnes - 1; c++) {
=======
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
>>>>>>> c536bdc1794e5cd2e850ab0bb9cd40b9ec0bbe06
                System.out.print(cases[l][c] + " ");
            }
            System.out.println();
        }
    }

    public static Case[][] plateauNiveau1() {
        Case[][] cases = {
                { new Case(null, false), new Case(null, false), new Case(null, false), new Case(null, false),
                        new Case(null, false), new Case(null, false), },
                { new Case(null, false), new Case(new Brique(10, Couleur.violet), true),
                        new Case(new Animal(20, "Chat", ""), true), new Case(new Brique(10, Couleur.rouge), true),
                        new Case(null, false), new Case(null, false), },
                { new Case(null, false), new Case(new Brique(10, Couleur.violet), true),
                        new Case(new Brique(10, Couleur.jaune), true), new Case(new Brique(10, Couleur.rouge), true),
                        new Case(new Animal(20, "Chien", ""), true), new Case(null, false), },
                { new Case(null, false), new Case(new Brique(10, Couleur.violet), true),
                        new Case(new Brique(10, Couleur.jaune), true), new Case(new Brique(10, Couleur.rouge), true),
                        new Case(new Brique(10, Couleur.rouge), true), new Case(null, false), },
<<<<<<< HEAD
                { new Case(null, false), new Case(new Brique(10, Couleur.orange), true),
                        new Case(new Brique(10, Couleur.orange), true), new Case(new Brique(10, Couleur.bleu), true),
                        new Case(new Brique(10, Couleur.bleu), true), new Case(null, false), },
                { new Case(null, false), new Case(new Brique(10, Couleur.orange), true),
                        new Case(new Brique(10, Couleur.bleu), true), new Case(new Brique(10, Couleur.bleu), true),
                        new Case(new Brique(10, Couleur.bleu), true), new Case(null, false), },
                { new Case(null, false), new Case(null, false), new Case(null, false), new Case(null, false),
                        new Case(null, false), new Case(null, false), } };

        return cases;
=======
                { new Case(new Brique(10, Couleur.violet), true), new Case(new Brique(10, Couleur.jaune), true),
                        new Case(new Brique(10, Couleur.rouge), true), new Case(new Animal(20, "Chien", ""), true), },
                { new Case(new Brique(10, Couleur.violet), true), new Case(new Brique(10, Couleur.jaune), true),
                        new Case(new Brique(10, Couleur.rouge), true), new Case(new Brique(10, Couleur.rouge), true), },
                { new Case(new Brique(10, Couleur.violet), true), new Case(new Brique(10, Couleur.violet), true),
                        new Case(new Brique(10, Couleur.bleu), true), new Case(new Brique(10, Couleur.bleu), true), },
                { new Case(new Brique(10, Couleur.violet), true), new Case(new Brique(10, Couleur.bleu), true),
                        new Case(new Brique(10, Couleur.bleu), true), new Case(new Brique(10, Couleur.bleu), true), } };

        return cases1;
>>>>>>> c536bdc1794e5cd2e850ab0bb9cd40b9ec0bbe06
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

    public void detruireBriqueAux(int l, int c, Couleur couleur) {

        if (l >= lignes || l < 0 || c >= colonnes || c < 0) {
            System.out.println("mauvaise selection des indices ");
            return;
        } else if (!cases[l][c].isActive()) {
            System.out.println("Case hors de jeu");
            return;

        } else if (cases[l][c].estVide()) {
            System.out.println("case vide");
            return;

        } else if (!(cases[l][c].estUneBrique()))
            return;
<<<<<<< HEAD
        else {
            if (cases[l][c + 1].getBrique().getCouleur() == couleur) {
                cases[l][c].vider();
                detruireBriqueAux(l, c + 1, couleur);
            }
            if (cases[l][c - 1].getBrique().getCouleur() == couleur) {
                cases[l][c].vider();
                detruireBriqueAux(l, c + 1, couleur);
            }
            if (cases[l + 1][c].getBrique().getCouleur() == couleur) {
                cases[l][c].vider();
                detruireBriqueAux(l + 1, c, couleur);
            }
            if (cases[l - 1][c].getBrique().getCouleur() == couleur) {
                cases[l][c].vider();
                detruireBriqueAux(l - 1, c, couleur);
            }
            return;
        }
        // Couleur couleurCible = ((Brique) cases[l][c].getElement()).getCouleur();
=======

        if ((cases[l][c].getBrique().getCouleur() == couleur)) {
            cases[l][c].vider();
        } else
            return;

        detruireBriqueAux(l, c + 1, couleur, acc + 1);
        detruireBriqueAux(l, c - 1, couleur, acc + 1);
        detruireBriqueAux(l + 1, c, couleur, acc + 1);
        detruireBriqueAux(l - 1, c, couleur, acc + 1);
>>>>>>> c536bdc1794e5cd2e850ab0bb9cd40b9ec0bbe06

    }

    public void detruire(int l, int c) {
<<<<<<< HEAD
        if (!cases[l][c].estVide()) {
            if (cases[l][c].estUneBrique()) {
                detruireBriqueAux(l, c, cases[l][c].getBrique().getCouleur());
            } else {
                System.out.println("ce n'est pas une brique");
            }
        }
    }

    // public void destruction(int l, int c) {
    // if (!cases[l][c].estVide()) {
    // if (cases[l][c].estUneBrique()) {

    // }
    // }
    // }

=======
        if (cases[l][c].estUneBrique()) {
            System.out.println("couleur selectionée est " + cases[l][c].getBrique().getCouleur());
            detruireBriqueAux(l, c, cases[l][c].getBrique().getCouleur(), 1);
        } else {
            System.out.println("ce n'est pas une brique");
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
>>>>>>> c536bdc1794e5cd2e850ab0bb9cd40b9ec0bbe06
}
