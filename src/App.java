import java.util.ArrayList;
import java.util.Scanner;

import Environnement.*;
import Movible.*;

public class App {

        public static void main(String[] args) throws Exception {
                /// Creation du niveau :
                Jeu.sauvegarderNiveau(new Niveau(1, new Plateau(Plateau.plateauNiveau1()), new Conditions(2, 34),
                                new ArrayList<Aide>()));
                ArrayList<Aide> arrayList = new ArrayList<>();
                arrayList.add(new Indice());
                arrayList.add(new Missile());
                Jeu.sauvegarderNiveau(new Niveau(2, new Plateau(Plateau.plateauNiveau2()), new Conditions(3, 130),
                                arrayList));
                // Jeu.lancerJeu();
                // try {
                // Jeu.joueurEnModeConsole();
                // } catch (Exception e) {
                // System.out.println(e);
                // }
                // Scanner sc = new Scanner(System.in);
        }
}
