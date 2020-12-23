package Environnement;

import java.io.Serializable;

public abstract class Aide implements Serializable { /// pour identifier les aides qu'un joueur peut avoir(missile et

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /// indice).
    public abstract void executer(Plateau plateau, int colonne);
}
