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

    public void afficher() {
        for (int l = 1; l < this.cases.length - 1; l++) {
            for (int c = 1; c < this.cases[0].length - 1; c++) {
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
    /// voir si je peux la supprimer après.
    // private void detruireBrique(int l, int c, int acc) {

    // if (l >= lignes || l < 0 || c >= colonnes || c < 0) {
    // System.out.println("mauvaise selection des indices ");
    // return;
    // } else if (!cases[l][c].isActive()) {
    // System.out.println("Case hors de jeu");
    // return;
    // } else if (!(cases[l][c].getElement() instanceof Brique))
    // return;

    // if (acc > 1) {
    // cases[l][c].vider();
    // }

    // Couleur couleurCible = ((Brique) cases[l][c].getElement()).getCouleur();

    // if (((Brique) cases[l][c + 1].getElement()).getCouleur() == couleurCible) {
    // detruireBrique(l, c + 1, acc + 1);
    // }
    // if (((Brique) cases[l][c - 1].getElement()).getCouleur() == couleurCible) {
    // detruireBrique(l, c - 1, acc + 1);
    // }
    // if (((Brique) cases[l + 1][c].getElement()).getCouleur() == couleurCible) {
    // detruireBrique(l + 1, c, acc + 1);
    // }
    // if (((Brique) cases[l - 1][c].getElement()).getCouleur() == couleurCible) {
    // detruireBrique(l - 1, c, acc + 1);
    // }

    // }

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
        if (!cases[l][c].estVide()) {
            if (cases[l][c].estUneBrique()) {
                if (!cases[l - 1][c].estVide()
                        && cases[l - 1][c].getBrique().getCouleur() == cases[l][c].getBrique().getCouleur()) {
                    score = detruireBriqueAux(l, c, cases[l][c].getBrique().getCouleur(), 1);
                } else if (!cases[l + 1][c].estVide()
                        && cases[l + 1][c].getBrique().getCouleur() == cases[l][c].getBrique().getCouleur()) {
                    score = detruireBriqueAux(l, c, cases[l][c].getBrique().getCouleur(), 1);
                } else if (!cases[l][c + 1].estVide()
                        && cases[l][c + 1].getBrique().getCouleur() == cases[l][c].getBrique().getCouleur()) {
                    score = detruireBriqueAux(l, c, cases[l][c].getBrique().getCouleur(), 1);
                } else if (!cases[l][c - 1].estVide()
                        && cases[l][c - 1].getBrique().getCouleur() == cases[l][c].getBrique().getCouleur()) {
                    score = detruireBriqueAux(l, c, cases[l][c].getBrique().getCouleur(), 1);
                }

            } else {
                System.out.println("Ce n'est pas une brique !!!");
                return 0;
            }
        } else {
            System.out.println("La case est vide !!!");
        }
        return score;
    }

    public void reorganiserPlateau() throws CloneNotSupportedException { /// cette fonction fait la reorganisation d'un
                                                                         /// plateau avec les memes principes présents
                                                                         /// sur le jeu petRescueSagae.
        boolean terminer = false;
        boolean obstacleColonne;/// pour detecter un obstacle.
        boolean arreter;
        int i = 1; /// pour les colonnes
        int j = cases.length - 2; /// pour les lignes
        int switcher, nbCasesActivesVidesColonnes;
        while (!terminer) { /// tant que le processus de reorganisation n'est pas terminé.
            if (cases[j][i].estVide() && cases[j][i].isActive()) {/// verifier si une case est vide donc elle était
                                                                  /// pleine et ensuite elle est détruite.
                switcher = j; /// pour l'utiliser dans la permutation des cases.
                j--;
                obstacleColonne = false;/// pour detecter un obstacle dans une colonne.
                nbCasesActivesVidesColonnes = 1; /// pour le calcul des cases vides dans une colonne.
                while (!obstacleColonne && j > 0) {/// tant que on a pas trouver un obstacle dans la colonne ou on a
                                                   /// finit la lecture de la colonne.
                    if (!cases[j][i].estVide()) {/// verifier si on trouve une case non vide dans la colonne.
                        if (cases[j][i].getElement().estMobile()) {/// verifier si c'est un élément movible.
                            cases[switcher][i] = (Case) cases[j][i].clone();/// cloner l'élément et le mettre dans la
                                                                            /// case vide.
                            cases[j][i].vider();/// vider la case d'où on a prit l'élément.
                            switcher--;/// décrementer le switcher pour indexer la prochaine case vide.
                        } else /// ajouter un traitement aprés.
                            obstacleColonne = true;
                    } else if (cases[j][i].isActive())/// faire le calcul de nombre de cases vides dans la colonne.
                        nbCasesActivesVidesColonnes++;
                    j--;
                }
                i++;/// passer à la prochaine colonne.
                j = cases.length - 2;
                if (i > cases[0].length - 2) {/// verifier si on est arrivé à la fin du tableau.
                    terminer = true;
                } else {
                    if (nbCasesActivesVidesColonnes == cases.length - 2) {/// verifier si une colonne est totalement
                                                                          /// vide pour la remplir des éléments des
                                                                          /// prochaines colonnes.
                        switcher = j;
                        arreter = false;/// il est utilisé pour arreter la boucle dans le cas où il y'a un obstacle dans
                                        /// la colonnes vides.
                        while (!arreter && j > 0) {

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
                        j = cases.length - 2;
                    }
                }
            } else {
                j--;
                if (j == 0) {
                    j = cases.length - 2;
                    i++;
                    if (i > cases[0].length - 2)
                        terminer = true;
                }
            }
        }
    }
}
