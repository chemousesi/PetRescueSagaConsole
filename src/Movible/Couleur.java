package Movible;

public enum Couleur {
    jaune("Jaune"), rouge("Rouge"), bleu("Bleu"), violet("Violet"); /// penser à ajouter si nécessaires.

    private String couleur;

    private Couleur(String couleur) {
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }
}
