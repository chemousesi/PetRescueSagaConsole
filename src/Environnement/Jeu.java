package Environnement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Jeu {
    private static Niveau niveau[];
    private static int nbNiveaux = 1;
    private static ArrayList<Joueur> joueurs;
    private static Parametres parameteresDuJeu;

    public static void lancerJeu() {/// elle fait la configuration nécessaire pour lancer le jeu.
        telechargerNiveaux();
        telechargerJoueurs();
        telechargerParametresDuJeu();
    }

    public static Partie lancerPartie(Joueur joueur, Niveau niveau) {
        return new Partie(niveau, joueur);
    }

    private static void telechargerNiveaux() {
        final String niv = "Niveau";
        ObjectInputStream reader;
        for (int i = 1; i <= nbNiveaux; i++) {
            try {
                reader = new ObjectInputStream(new FileInputStream(niv + String.valueOf(i)));
                niveau[i - 1] = (Niveau) reader.readObject();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private static void telechargerJoueurs() {
        // explain here

    }

    private static void telechargerParametresDuJeu() {
        // explain here

    }

    public static void Welcome() {
        System.out.println("Bienvenus dans Pet Rescue saga");
        // affichage du plateau

    }

    public static void menu() {
        // premier menu du jeu
        Scanner sc = new Scanner(System.in);
        boolean validInput = false;
        int choix = -1;// string pour traiter les mmauvaises
        System.out.println("Faites un choix");
        do {
            System.out.println("1 - choix Joueur");
            System.out.println("2 - choix Commencer une partie");
            System.out.println("3 - commencer une partie");
            System.out.println("0 - quitter");

            System.out.println(" Votre choix : ");
            try {
                choix = Integer.parseInt(sc.next());
                validInput = true;
            } catch (Exception e) {
                System.out.println("problème d'entrée");

            }

        } while ((!validInput) || (choix < 0) || (choix > 3));
    }

}
