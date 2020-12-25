package Environnement;

import java.io.Serializable;
import Movible.*;

public class Plateau implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
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
        String espace = "                                 ";
        System.out.println("\n                         " + "################## Plateau ###################\n");
        System.out.print(espace + "   ");
        for (int i = 1; i < this.cases[0].length - 1; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();// r etour à la ligne
        for (int l = 1; l < this.cases.length - 1; l++) {// affichage des lignes
            System.out.print(espace + l + "  ");

            for (int c = 1; c < this.cases[0].length - 1; c++) { // affichafe des colonnes

                System.out.print(cases[l][c] + "  ");
            }
            System.out.println();
        }
        System.out.println("\n                         " + "##############################################\n");
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

    public static Case[][] plateauNiveau2() {
        Case[][] cases = {
                { new Case(null, false), new Case(null, false), new Case(null, false), new Case(null, false),
                        new Case(null, false), new Case(null, false), new Case(null, false), new Case(null, false),
                        new Case(null, false), new Case(null, false) },
                { new Case(null, false), new Case(new Obstacle(0, Couleur.gris), true),
                        new Case(new Obstacle(0, Couleur.gris), true), new Case(new Obstacle(0, Couleur.gris), true),
                        new Case(new Brique(10, Couleur.bleu), true), new Case(new Animal(20, "Chien", ""), true),
                        new Case(new Obstacle(0, Couleur.gris), true), new Case(new Obstacle(0, Couleur.gris), true),
                        new Case(new Obstacle(0, Couleur.gris), true), new Case(null, false) },
                { new Case(null, false), new Case(new Obstacle(0, Couleur.gris), true),
                        new Case(new Obstacle(0, Couleur.gris), true), new Case(new Brique(10, Couleur.bleu), true),
                        new Case(new Brique(10, Couleur.bleu), true), new Case(new Brique(10, Couleur.bleu), true),
                        new Case(new Brique(10, Couleur.rouge), true), new Case(new Obstacle(0, Couleur.gris), true),
                        new Case(new Obstacle(0, Couleur.gris), true), new Case(null, false) },
                { new Case(null, false), new Case(new Obstacle(0, Couleur.gris), true),
                        new Case(new Brique(10, Couleur.bleu), true), new Case(new Brique(10, Couleur.orange), true),
                        new Case(new Brique(10, Couleur.orange), true), new Case(new Animal(20, "Chien", ""), true),
                        new Case(new Brique(10, Couleur.rouge), true), new Case(new Brique(10, Couleur.orange), true),
                        new Case(new Obstacle(0, Couleur.gris), true), new Case(null, false) },
                { new Case(null, false), new Case(new Brique(10, Couleur.bleu), true),
                        new Case(new Brique(10, Couleur.bleu), true), new Case(new Brique(10, Couleur.orange), true),
                        new Case(new Brique(10, Couleur.violet), true), new Case(new Obstacle(0, Couleur.gris), true),
                        new Case(new Brique(10, Couleur.rouge), true), new Case(new Brique(10, Couleur.orange), true),
                        new Case(new Animal(20, "Chien", ""), true), new Case(null, false) },
                { new Case(null, false), new Case(new Brique(10, Couleur.bleu), true),
                        new Case(new Brique(10, Couleur.bleu), true), new Case(new Brique(10, Couleur.rouge), true),
                        new Case(new Brique(10, Couleur.violet), true), new Case(new Brique(10, Couleur.rouge), true),
                        new Case(new Brique(10, Couleur.bleu), true), new Case(new Brique(10, Couleur.orange), true),
                        new Case(new Brique(10, Couleur.violet), true), new Case(null, false) },
                { new Case(null, false), new Case(new Brique(10, Couleur.jaune), true),
                        new Case(new Brique(10, Couleur.jaune), true), new Case(new Brique(10, Couleur.rouge), true),
                        new Case(new Brique(10, Couleur.rouge), true), new Case(new Brique(10, Couleur.violet), true),
                        new Case(new Brique(10, Couleur.bleu), true), new Case(new Brique(10, Couleur.violet), true),
                        new Case(new Brique(10, Couleur.violet), true), new Case(null, false) },
                { new Case(null, false), new Case(new Obstacle(0, Couleur.gris), true),
                        new Case(new Brique(10, Couleur.jaune), true), new Case(new Brique(10, Couleur.orange), true),
                        new Case(new Brique(10, Couleur.orange), true), new Case(new Brique(10, Couleur.orange), true),
                        new Case(new Brique(10, Couleur.rouge), true), new Case(new Brique(10, Couleur.rouge), true),
                        new Case(new Obstacle(0, Couleur.gris), true), new Case(null, false) },
                { new Case(null, false), new Case(new Obstacle(0, Couleur.gris), true),
                        new Case(new Obstacle(0, Couleur.gris), true), new Case(new Brique(10, Couleur.violet), true),
                        new Case(new Brique(10, Couleur.jaune), true), new Case(new Brique(10, Couleur.jaune), true),
                        new Case(new Brique(10, Couleur.rouge), true), new Case(new Obstacle(0, Couleur.gris), true),
                        new Case(new Obstacle(0, Couleur.gris), true), new Case(null, false) },
                { new Case(null, false), new Case(new Obstacle(0, Couleur.gris), true),
                        new Case(new Obstacle(0, Couleur.gris), true), new Case(new Obstacle(0, Couleur.gris), true),
                        new Case(new Brique(10, Couleur.violet), true), new Case(new Brique(10, Couleur.jaune), true),
                        new Case(new Obstacle(0, Couleur.gris), true), new Case(new Obstacle(0, Couleur.gris), true),
                        new Case(new Obstacle(0, Couleur.gris), true), new Case(null, false) },
                { new Case(null, false), new Case(null, false), new Case(null, false), new Case(null, false),
                        new Case(null, false), new Case(null, false), new Case(null, false), new Case(null, false),
                        new Case(null, false), new Case(null, false) } };
        return cases;
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
        if (!cases[l][c].estVide()) {
            if (cases[l][c].estUneBrique()) {
                if (!cases[l - 1][c].estVide() && cases[l - 1][c].estUneBrique()
                        && cases[l - 1][c].getBrique().getCouleur() == cases[l][c].getBrique().getCouleur()) {
                    score = detruireBriqueAux(l, c, cases[l][c].getBrique().getCouleur(), 1);
                } else if (!cases[l + 1][c].estVide() && cases[l + 1][c].estUneBrique()
                        && cases[l + 1][c].getBrique().getCouleur() == cases[l][c].getBrique().getCouleur()) {
                    score = detruireBriqueAux(l, c, cases[l][c].getBrique().getCouleur(), 1);
                } else if (!cases[l][c + 1].estVide() && cases[l][c + 1].estUneBrique()
                        && cases[l][c + 1].getBrique().getCouleur() == cases[l][c].getBrique().getCouleur()) {
                    score = detruireBriqueAux(l, c, cases[l][c].getBrique().getCouleur(), 1);
                } else if (!cases[l][c - 1].estVide() && cases[l][c - 1].estUneBrique()
                        && cases[l][c - 1].getBrique().getCouleur() == cases[l][c].getBrique().getCouleur()) {
                    score = detruireBriqueAux(l, c, cases[l][c].getBrique().getCouleur(), 1);
                }

            } else {
                System.out.println("Ce n'est pas une brique !!!");
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
        boolean enter = false;
        int i = 1; /// pour les colonnes
        int j = cases.length - 2; /// pour les lignes
        int switcher, nbCasesActivesVidesColonnes, videColPrec, obstacleLigne;
        while (!terminer) { /// tant que le processus de reorganisation n'est pas terminé.
            if (cases[j][i].estVide() && cases[j][i].isActive()) {/// verifier si une case est
                                                                  /// vide donc elle était
                /// pleine et ensuite elle est détruite.
                switcher = j; /// pour l'utiliser dans la permutation des cases.
                j--;
                obstacleColonne = false;/// pour detecter un obstacle dans une colonne.
                nbCasesActivesVidesColonnes = 1; /// pour le calcul des cases vides dans une colonne.
                while (!obstacleColonne && j > 0) {/// tant que on a pas trouver un obstacle dans la colonne ou on a
                                                   /// finit la lecture de la colonne.
                    if (!cases[j][i].estVide()) {/// verifier si on trouve une case non vide dans la colonne.
                        if (cases[j][i].getElement().estMobile() && cases[switcher][i].estVide()) {/// verifier si c'est
                                                                                                   /// un élément
                                                                                                   /// movible.
                            cases[switcher][i] = (Case) cases[j][i].clone();/// cloner l'élément et le mettre dans la
                                                                            /// case vide.
                            cases[j][i].vider();/// vider la case d'où on a prit l'élément.
                            switcher--;/// décrementer le switcher pour indexer la prochaine case vide.
                        } else { /// ajouter un traitement aprés.
                            /// voir si les cases de la gauches sont vides
                            switcher = j - 1;
                            if (i - 1 >= 1) {
                                if (cases[j][i - 1].estVide()) {
                                    obstacleColonne = true;
                                    obstacleLigne = j;
                                    videColPrec = j + 1;
                                    switcher = j - 1;
                                    while (videColPrec <= cases.length - 2 && cases[videColPrec][i - 1].estVide()) {
                                        videColPrec++;
                                    }
                                    if (videColPrec <= cases.length - 2)
                                        videColPrec--;
                                    j--;
                                    while (j > 0) {
                                        if (!cases[j][i].estVide() && cases[j][i].getElement().estMobile()) {
                                            if (videColPrec >= obstacleLigne) {
                                                cases[videColPrec][i - 1] = (Case) cases[j][i].clone();
                                                cases[j][i].vider();
                                                videColPrec--;
                                                enter = true;
                                            } else {
                                                cases[switcher][i] = (Case) cases[j][i].clone();
                                                cases[j][i].vider();
                                                switcher--;
                                            }
                                        }
                                        j--;
                                    }
                                    if (enter) {
                                        i = i - 1;
                                        j = cases.length - 1;
                                        enter = false;
                                    }
                                }
                            }
                        }
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
            } else if (!cases[j][i].estVide() && !cases[j][i].getElement().estMobile()) {
                if (i - 1 >= 1) {
                    if (cases[j][i - 1].estVide()) {
                        obstacleLigne = j;
                        videColPrec = j + 1;
                        switcher = j - 1;
                        while (videColPrec <= cases.length - 2 && cases[videColPrec][i - 1].estVide()) {
                            videColPrec++;
                        }
                        if (videColPrec <= cases.length - 2)
                            videColPrec--;
                        j--;
                        while (j > 0) {
                            if (!cases[j][i].estVide() && cases[j][i].getElement().estMobile()) {
                                if (videColPrec >= obstacleLigne) {
                                    cases[videColPrec][i - 1] = (Case) cases[j][i].clone();
                                    cases[j][i].vider();
                                    videColPrec--;
                                    enter = true;
                                } else {
                                    cases[switcher][i] = (Case) cases[j][i].clone();
                                    cases[j][i].vider();
                                    switcher--;
                                }
                            }
                            j--;
                        }
                        if (enter) {
                            i = i - 1;
                            j = cases.length - 1;
                            enter = false;
                        } else {
                            i++;
                            j = cases.length - 2;
                            if (i > cases[0].length - 2)
                                terminer = true;
                        }

                    } else {
                        j--;
                        if (j == 0) {
                            i++;
                            j = cases.length - 2;
                            if (i > cases[0].length - 2)
                                terminer = true;
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

    public int animalSauve() throws CloneNotSupportedException {
        int nbAnimaux = 0;
        boolean fin = false;
        boolean enter;
        do {
            enter = false;
            for (int i = 1; i < cases[0].length - 1; i++) {
                if (!cases[cases.length - 2][i].estVide() && cases[cases.length - 2][i].estUnAnimal()) {
                    nbAnimaux++;
                    cases[cases.length - 2][i].vider();
                    enter = true;
                }
            }
            if (enter)
                this.reorganiserPlateau();
            else
                fin = true;
        } while (!fin);

        return nbAnimaux;

    }
}
