import java.util.ArrayList;

import Environnement.*;
import Movible.*;

public class App {
    public static void main(String[] args) throws Exception {
        /// Creation du niveau :
        Case[][] cases = {
                { new Case(new Brique(10, Couleur.violet), true), new Case(new Brique(10, Couleur.violet), true),
                        new Case(new Brique(10, Couleur.violet), true), new Case(new Brique(10, Couleur.vert), true),
                        new Case(new Brique(10, Couleur.vert), true) },
                { new Case(new Animal(20, "Chat", ""), true), new Case(new Brique(10, Couleur.jaune), true),
                        new Case(new Brique(10, Couleur.jaune), true), new Case(new Brique(10, Couleur.vert), true),
                        new Case(new Brique(10, Couleur.bleu), true), },
                { new Case(new Brique(10, Couleur.rouge), true), new Case(new Brique(10, Couleur.rouge), true),
                        new Case(new Brique(10, Couleur.rouge), true), new Case(new Brique(10, Couleur.bleu), true),
                        new Case(new Brique(10, Couleur.bleu), true) },
                {} };
        Niveau niveau = new Niveau(1, new Plateau(cases), new Conditions(2, 140), new ArrayList<Aide>());
        Joueur joueur = new Joueur("Nouredine");

        Plateau p = new Plateau(10, 10);
        p.afficher(); // affichage d'un plateau vide
        niveau.getPlateau().afficher(); // affichage du plateau construit
    }
}
