import Environnement.*;

public class App {
    public static void main(String[] args) throws Exception {
        Niveau niveau = new Niveau();
        Joueur joueur = new Joueur("Nouredine");

        Plateau p = new Plateau(10, 10);
        p.afficher();

    }
}
