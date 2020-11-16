import java.util.ArrayList;

import Environnement.*;
import Movible.*;

public class App {
    public static void main(String[] args) throws Exception {
        /// Creation du niveau :
        Case[][] cases = { { new Case(new Brique(10, Couleur.violet), false),
                new Case(new Brique(10, Couleur.violet), false), new Case(new Brique(10, Couleur.violet), false),
                new Case(new Brique(10, Couleur.vert), false), new Case(new Brique(10, Couleur.vert), false) }, {}, {},
                {} };
        Niveau niveau = new Niveau(1, new Plateau(cases), new Conditions(2, 140), new ArrayList<Aide>());
        Joueur joueur = new Joueur("Nouredine");
    }
}
