import java.util.ArrayList;
import java.util.Scanner;

import Environnement.*;
import Movible.*;

public class App {

        public static void main(String[] args) throws Exception {
                /// Creation du niveau :
                Jeu.lancerJeu();
                try {
                        Jeu.joueurEnModeConsole();
                } catch (Exception e) {
                        System.out.println(e);
                }
                // Scanner sc = new Scanner(System.in);
        }
}
