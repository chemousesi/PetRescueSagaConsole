package Environnement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Partie {
    private Niveau niveauAJouer;
    private Joueur joueur;
    private int nbPointsGangerParLeJoueur;
    private int nbAnimauxSauves;
    private boolean abondonner;

    public Partie(Niveau niveau, Joueur joueur) {
        this.niveauAJouer = niveau;
        this.joueur = joueur;
        this.nbPointsGangerParLeJoueur = 0;
        this.nbAnimauxSauves = 0;
        this.abondonner = false;
    }

    private boolean estGagne() {
        return niveauAJouer.getConditionsDeGagner().getNbAnimauxASauver() == this.nbAnimauxSauves
                && niveauAJouer.getConditionsDeGagner().getNbPointsAGagner() <= this.nbPointsGangerParLeJoueur;
    }

    private boolean estPerdue() {
        /// faire le traitement pour savoir si la partie est perdue.
        return false;
    }

    private boolean abondonner() {
        return this.abondonner;
    }

    public void setAbondonner(boolean abondonner) {
        this.abondonner = abondonner;
    }

    public void jouerUnePartieModeTexte() throws CloneNotSupportedException {
        int coordX, coordY;
        Scanner scanner = new Scanner(System.in);

        /// ajouter des retouches ici.
        while (!estGagne() && !abondonner() && !estPerdue()) { /// tant que la parite n'es pas gagné
            this.niveauAJouer.printConditionsGagner();
            this.niveauAJouer.getPlateau().afficher();

            System.out.println("                     Nombre de points gagnés : " + this.nbPointsGangerParLeJoueur
                    + "  Nombre d'animaux sauvés : " + this.nbAnimauxSauves + "\n");
            System.out.println("--> Indiquer la case à detruire: ");
            // il faut rajouter l'utilisation de missile ici
            try {

                System.out.print("Tapez le n° de la colonne : ");
                coordX = scanner.nextInt();
                System.out.print("Tapez le n° de la ligne   : ");
                coordY = scanner.nextInt();
                this.nbPointsGangerParLeJoueur += this.niveauAJouer.getPlateau().detruire(coordY, coordX);
                this.niveauAJouer.getPlateau().reorganiserPlateau();
                this.nbAnimauxSauves += this.niveauAJouer.getPlateau().animalSauve();
            } catch (InputMismatchException e) {
                scanner.next();// on pourra traiter le problème du missile ici
                System.out.println("Entrée non valide");

            }

        }
        if (estGagne()) {
            this.joueur.incrementerNivActuel();
            this.joueur.incrementeScore(nbPointsGangerParLeJoueur + 10 * nbAnimauxSauves);
            System.out.println("Le partie est gagné !!!");
        } else if (abondonner) {
            /// traitement ici
        } else {
            System.out.println("La partie est perdue !!");
        }
        scanner.close();
    }

}
