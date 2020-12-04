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
    private static int nbJoueurs = 0;
    private static Parametres parameteresDuJeu;
    /// utilisé dans toutes les lectures.
    private static Scanner sc = new Scanner(System.in);

    public static void lancerJeu() {/// elle fait la configuration nécessaire pour lancer le jeu.
        telechargerNiveaux();
        telechargerJoueurs();
        telechargerParametresDuJeu();
    }

    private static Partie lancerPartie(Joueur joueur) {
        return new Partie(niveau[joueur.getniveauActuel() - 1], joueur);
    }

    public static void joueurEnModeConsole() throws UserNotFound, CloneNotSupportedException {
        welcome();
        String[] premiersChoix = { "1- Connexion", "2- Inscription", "3- Quitter" };
        int choix_1 = menuTextuelle(premiersChoix);
        Joueur joueur = null;
        switch (choix_1) {
            case 1:/// connexion
                joueur = connexion();
                break;

            case 2:/// inscription
                joueur = creerJoueur();
                break;
            case 3:/// quitter
                System.exit(0);
                break;
        }
        if (joueur == null)
            throw new UserNotFound();
        String[] deuxiemeChoix = { "1- Jouer", "2- Historique", "3- Help", "4- Deconnexion" };
        int choix_2 = menuTextuelle(deuxiemeChoix);
        switch (choix_2) {
            case 1:/// jouer.
                Partie partie = lancerPartie(joueur);
                partie.jouerUnePartieModeTexte();
                break;
            case 2:/// historique.
                break;
            case 3:/// affichage d'un manuel.
                break;
            case 4: /// deconnexion.
                break;
        }
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
        joueurs = new ArrayList<>();
        ObjectInputStream reader;
        final String joueur = "Joueur";
        for (int i = 1; i <= nbJoueurs; i++) {
            try {
                String path = "src/Joueurs/" + joueur + String.valueOf(i) + ".txt";
                reader = new ObjectInputStream(new FileInputStream(path));
                joueurs.add((Joueur) reader.readObject());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void sauvegarderJoueurs() {
        final String joueur = "Niveau";
        ObjectOutputStream writer = null;

        try {
            for (int i = 1; i <= nbJoueurs; i++) {
                String path = "src/Joueurs/" + joueur + String.valueOf(i) + ".txt";
                writer = new ObjectOutputStream(new FileOutputStream(path));
                writer.writeObject(joueurs.get(i - 1));
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void telechargerParametresDuJeu() {
        // explain here

    }

    private static void welcome() {
        System.out.println("Bienvenus dans Pet Rescue saga");
        // affichage du plateau
    }

    private static int menuTextuelle(String[] tabDeChoix) { /// amelioration du menu.
        // premier menu du jeu
        for (String choix : tabDeChoix) {
            System.out.println(choix);
        }
        int choix = 0;
        do {
            System.out.print("Tapez votre choix : ");
            choix = sc.nextInt();
        } while (choix < 1 || choix > tabDeChoix.length);
        return choix;
    }

    private static Joueur creerJoueur() {
        System.out.println("Créer un nouveau joueur");
        System.out.print("Saisir votre nom : ");
        sc.next();
        String nom = sc.nextLine();
        Joueur joueur = null;
        do {
            System.out.print("Saisir votre nom d'utilisateur : ");
            String nomUser = sc.nextLine();
            joueur = new Joueur(nom, nomUser);
        } while (joueurs.contains(joueur));
        joueurs.add(joueur);
        nbJoueurs++;
        return joueur;
    }

    private static Joueur connexion() {
        System.out.println("Se connecter");
        System.out.print("votre pseudo : ");
        String nomUser = sc.next();
        for (Joueur joueur : joueurs) {
            if (joueur.getNomUtilisateur().equals(nomUser)) {
                sc.close();
                return joueur;
            }
        }
        return null;
    }
}
