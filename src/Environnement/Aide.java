package Environnement;

import java.io.Serializable;

public abstract class Aide implements Serializable { /// pour identifier les aides qu'un joueur peut avoir(missile et
                                                     /// indice).
    public abstract void executer(Plateau plateau, int colonne);
}
