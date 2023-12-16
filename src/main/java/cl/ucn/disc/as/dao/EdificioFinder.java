package cl.ucn.disc.as.dao;

import cl.ucn.disc.as.model.Edificio;
import io.ebean.Finder;

public class EdificioFinder extends Finder<Long, Edificio> {

    /**
     * The Constructor.
     */
    public EdificioFinder() {
        super(Edificio.class);
    }
}
