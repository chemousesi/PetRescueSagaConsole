import java.util.ArrayList;
import java.util.Scanner;

import Environnement.*;
import Movible.*;

public class App {

        public static void main(String[] args) throws Exception {
                /// Creation du niveau :
                // Jeu.sauvegarderNiveau(new Niveau(1, new Plateau(Plateau.plateauNiveau1()),
                // new Conditions(2, 140),
                // new ArrayList<Aide>()));
                // Jeu.sauvegarderNiveau(new Niveau(2, new Plateau(Plateau.plateauNiveau2()),
                // new Conditions(3, 1300),
                // new ArrayList<Aide>() {
                // /**
                // *
                // */
                // private static final long serialVersionUID = 1L;

                // {
                // add(new Indice());
                // add(new Missile());
                // }
                // }));
                Jeu.lancerJeu();
                try {
                        Jeu.joueurEnModeConsole();
                } catch (Exception e) {
                        System.out.println(e);
                }
                // Scanner sc = new Scanner(System.in);
        }
}
