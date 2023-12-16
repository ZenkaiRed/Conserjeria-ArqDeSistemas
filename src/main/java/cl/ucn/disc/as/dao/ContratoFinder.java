package cl.ucn.disc.as.dao;

import cl.ucn.disc.as.model.Contrato;
import io.ebean.Finder;

/**
 * The Finder of Contrato.
 *
 * @author Marcelo Céspedes
 */
public class ContratoFinder extends Finder<Long, Contrato> {
    public ContratoFinder() {
        super(Contrato.class);
    }
}
