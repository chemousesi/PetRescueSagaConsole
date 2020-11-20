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
                && niveauAJouer.getConditionsDeGagner().getNbPointsAGagner() == this.nbPointsGangerParLeJoueur;
    }

    private boolean abondonner() {
        return this.abondonner;
    }

    public void jouerUnePartieModeTexte() {
        Scanner scanner = new Scanner(System.in);
        int coordX, coordY;
        String reponseAbondone;

        /// ajouter des retouches ici.
        while (!estGagne() && !abondonner()) { /// tant que la parite n'es pas gagné
            this.niveauAJouer.getPlateau().afficher();
            System.out.println("Tapez les coordonnées d'une case : ");
            System.out.print("Tapez la coordonnée X : ");
            coordX = scanner.nextInt();
            System.out.print("Tapez la coordonnée Y : ");
            coordY = scanner.nextInt();
            /// utiliser la méthode qui essaye de détruire la case sélectionnée et ces cases
            /// adjacente et elle rend le nombre de points gagnés.
            /// utiliser la méthode qui réorganise le plateau.
        }
        /// traitement si le joueur à gagner ou abondonner.
        scanner.close();
    }
}
