import java.util.ArrayList;

import Environnement.*;
import Movible.*;

public class App {

        public static void main(String[] args) throws Exception {
                /// Creation du niveau :
                Case[][] cases = Plateau.plateauNiveau1();
                System.out.println(cases.length + " | " + cases[0].length);
                Niveau niveau = new Niveau(1, new Plateau(cases), new Conditions(2, 140), new ArrayList<Aide>());
                Joueur joueur = new Joueur("Nouredine");
                Partie partie = Jeu.lancerPartie(joueur, niveau);

                // Plateau p = new Plateau(10, 10);
                // p.afficher(); // affichage d'un plateau vide
                niveau.getPlateau().afficher(); // affichage du plateau construit

                niveau.getPlateau().detruire(4, 2);
                niveau.getPlateau().afficher(); // affichage du plateau construit

                // Jeu.menu();
        }
}
