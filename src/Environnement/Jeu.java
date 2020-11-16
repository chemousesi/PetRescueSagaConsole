package Environnement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

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

    }

    private static void telechargerParametresDuJeu() {

    }
}
