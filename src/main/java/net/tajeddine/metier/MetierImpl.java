package net.tajeddine.metier;

import net.tajeddine.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("metier")
public class MetierImpl implements IMetier {
    private IDao dao; // Couplage Faible

    /*
     * Pour l'injecter le variable dans l'attribut dao
     * un objet d'une classe qui implémente l'interface IDao
     * au moment de instantiation de la classe MetierImpl
     */
    public MetierImpl(@Qualifier("d2") IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double t = dao.getData();
        double res = t * 12 * Math.PI/2 * Math.cos(t);
        return res;
    }


    /*
    * Pour l'injecter le variable dans l'attribut dao
    * un objet d'une classe qui implémente l'interface IDao
    * après instantiation de la classe MetierImpl
    */

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
