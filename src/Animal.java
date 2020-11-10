public class Animal {
    private String nom;
    private String icon;
    private int valeur;

    public Animal(String nom, String icon, int valeur) {
        this.nom = nom;
        this.icon = icon;
        this.valeur = valeur;

    }

    public String getNom() {
        return nom;
    }

    public int getValeur() {
        return valeur;
    }

    public String getIcon() {
        return icon;
    }

}
