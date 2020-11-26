package Environnement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Jeu {
    /// ajouter des retouches ici une fois les niveaux sont implementés.
    private static Niveau niveau[] = new Niveau[1];
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
                String path = "src/Niveaux/" + niv + String.valueOf(i) + ".txt";
                reader = new ObjectInputStream(new FileInputStream(path));
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

    public static void sauvegarderNiveau(Niveau niveau) {
        final String niv = "Niveau";
        ObjectOutputStream writer;
        try {
            String path = "src/Niveaux/" + niv + String.valueOf(niveau.getNumero()) + ".txt";
            writer = new ObjectOutputStream(new FileOutputStream(path));
            writer.writeObject(niveau);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
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

    public static void menuTextuelle() { /// amelioration du menu.
        // premier menu du jeu
        Scanner sc = new Scanner(System.in);
        int choix = -1;// string pour traiter les mmauvaises
        System.out.println("Faites un choix");
        do {
            System.out.println("1 - choix Joueur");
            System.out.println("2 - choix Commencer une partie");
            System.out.println("3 - commencer une partie");
            System.out.println("0 - quitter");

            System.out.println(" Votre choix : ");
            try {
                choix = sc.nextInt();
            } catch (Exception e) {
                System.out.println("problème d'entrée");

            }

        } while ((choix < 0) || (choix > 3));

    }

    public Joueur creerJoueur() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Créer un nouveau joueur");
        System.out.print("Saisir votre nom : ");
        String nom = sc.nextLine();
        Joueur joueur = null;
        do {
            System.out.print("Saisir votre nom d'utilisateur : ");
            String nomUser = sc.nextLine();
            joueur = new Joueur(nom, nomUser);
        } while (joueurs.contains(joueur));
        sc.close();
        return joueur;
    }

    public Joueur connexion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Se connecter");
        System.out.println("votre pseudo : ");
        String nomUser = sc.nextLine();
        sc.close();
        for (Joueur joueur : joueurs) {
            if (joueur.getNomUtilisateur().equals(nomUser))
                return joueur;
        }
        return null;
    }
}
