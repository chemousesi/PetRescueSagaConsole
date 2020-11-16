package Environnement;

import java.io.Serializable;
import java.util.ArrayList;

public class Niveau implements Serializable {
    private int numero;
    private Plateau plateau;
    private Conditions conditionsDeGagner;
    private ArrayList<Aide> listDesAides;

    Niveau(int numero, Plateau plateau, Conditions conditions, ArrayList<Aide> listeDesAides) {
        this.numero = numero;
        this.plateau = plateau;
        this.conditionsDeGagner = conditions;
        this.listDesAides = listeDesAides;
    }

    public Conditions getConditionsDeGagner() {
        return conditionsDeGagner;
    }

    public ArrayList<Aide> getListDesAides() {
        return listDesAides;
    }

    public int getNumero() {
        return numero;
    }

    public Plateau getPlateau() {
        return plateau;
    }
}
