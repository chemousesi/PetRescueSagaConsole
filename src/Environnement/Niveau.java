package Environnement;

import java.io.Serializable;
import java.util.ArrayList;

public class Niveau implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int numero;
    private Plateau plateau;
    private Conditions conditionsDeGagner;
    private ArrayList<Aide> listDesAides;
    private int nbMissiles;

    public Niveau(int numero, Plateau plateau, Conditions conditions, ArrayList<Aide> listeDesAides) {
        this.numero = numero;
        this.plateau = plateau;
        this.conditionsDeGagner = conditions;
        this.listDesAides = listeDesAides;
    }

    public void printConditionsGagner() {
        System.out.println("\t\t\t ########### Conditions Pour Gagner ###########");
        System.out.println("\t\t\t #                                            #");
        System.out.println("\t\t\t #   Nombre de points : " + this.conditionsDeGagner.getNbPointsAGagner()
                + "                   #");
        System.out.println("\t\t\t #   Nombre d'animaux : " + this.conditionsDeGagner.getNbAnimauxASauver()
                + "                     #");
        System.out.println("\t\t\t #                                            #");
        System.out.println("\t\t\t ##############################################");
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
