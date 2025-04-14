package net.tajeddine.pres;

import net.tajeddine.dao.DaoImpl;
import net.tajeddine.ext.DaoImplV2;
import net.tajeddine.metier.MetierImpl;

public class Pres1 {
    public static void main(String[] args) {
        DaoImplV2 d = new DaoImplV2();
        MetierImpl metier = new MetierImpl(d);
        //metier.setDao(d); // Injection des dépendances via setter
        System.out.println("RES = "+metier.calcul());
    }
}
