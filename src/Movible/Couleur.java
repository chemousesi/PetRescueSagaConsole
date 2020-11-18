package Movible;

public enum Couleur {
    jaune("Jaune"), rouge("Rouge"), bleu("Bleu"), violet("Violet"), vert("Vert"); /// penser à ajouter si nécessaires.

    private String couleur;

    private Couleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return String.valueOf(couleur.charAt(0));
    }

    public String getCouleur() {
        return couleur;
    }
}
