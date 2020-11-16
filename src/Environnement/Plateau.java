package Environnement;

import java.io.Serializable;
import java.util.ArrayList;
import Movible.*;

public class Plateau implements Serializable {
    private Case cases[][];

    public Plateau(Case[][] cases) {
        this.cases = cases;
    }

    public void initialiserPlateau() {
        // cette méthode va remplir le plateau avec des briques, des obstaclles et des
        // animaux, et aussi,
    }

}
