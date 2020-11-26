package Environnement;

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
                && niveauAJouer.getConditionsDeGagner().getNbPointsAGagner() >= this.nbPointsGangerParLeJoueur;
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
        Scanner scanner = new Scanner(System.in);
        int coordX, coordY;

        /// ajouter des retouches ici.
        while (!estGagne() && !abondonner() && !estPerdue()) { /// tant que la parite n'es pas gagné
            this.niveauAJouer.getPlateau().afficher();
            System.out.println("Tapez les coordonnées d'une case : ");
            System.out.print("Tapez la coordonnée X : ");
            coordX = scanner.nextInt();
            System.out.print("Tapez la coordonnée Y : ");
            coordY = scanner.nextInt();
            this.nbPointsGangerParLeJoueur += this.niveauAJouer.getPlateau().detruire(coordY, coordX);
            this.niveauAJouer.getPlateau().reorganiserPlateau();
            this.nbAnimauxSauves += this.niveauAJouer.getPlateau().animalSauve();
        }
        if (estGagne()) {
            this.joueur.incrementerNivActuel();
            System.out.println("Le partie est gagné !!!");
        } else if (abondonner) {
            /// traitement ici
        } else {
            System.out.println("La partie est perdue !!");
        }
        scanner.close();
    }
}
