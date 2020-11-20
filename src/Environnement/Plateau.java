package Environnement;

import java.io.Serializable;
import Movible.*;

public class Plateau implements Serializable {
    private Case cases[][];
    private int lignes;
    private int colonnes;

    public Plateau(Case[][] cases) {
        this.cases = cases;
        lignes = cases.length;
        colonnes = cases[0].length;
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
        for (int l = 0; l < lignes - 1; l++) {
            for (int c = 0; c < colonnes - 1; c++) {
                cases[l][c] = new Case();
            }
        }
    }

    public void afficher() {
        for (int l = 1; l < lignes - 1; l++) {
            for (int c = 1; c < colonnes - 1; c++) {
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
                { new Case(null, false), new Case(new Brique(10, Couleur.orange), true),
                        new Case(new Brique(10, Couleur.orange), true), new Case(new Brique(10, Couleur.bleu), true),
                        new Case(new Brique(10, Couleur.bleu), true), new Case(null, false), },
                { new Case(null, false), new Case(new Brique(10, Couleur.orange), true),
                        new Case(new Brique(10, Couleur.bleu), true), new Case(new Brique(10, Couleur.bleu), true),
                        new Case(new Brique(10, Couleur.bleu), true), new Case(null, false), },
                { new Case(null, false), new Case(null, false), new Case(null, false), new Case(null, false),
                        new Case(null, false), new Case(null, false), } };

        return cases;
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

    }

    public void detruire(int l, int c) {
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

}
