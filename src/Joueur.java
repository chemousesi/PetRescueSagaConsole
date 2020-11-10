public class Joueur {
    private String nom;
    private int score;
    private int niveauActuel;

    public Joueur(String nom) {
        this.nom = nom;
        this.score = 0;
        this.niveauActuel = 0;
    }

    public void setniveauActuel(int niveauActuel) {
        this.niveauActuel = niveauActuel;
    }

    public String getnom() {
        return nom;
    }

    public int getScore() {
        return score;
    }

    public int getniveauActuel() {
        return niveauActuel;
    }

}
