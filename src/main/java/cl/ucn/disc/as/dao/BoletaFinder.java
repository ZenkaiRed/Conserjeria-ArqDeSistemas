package cl.ucn.disc.as.dao;

import cl.ucn.disc.as.model.Boleta;
import cl.ucn.disc.as.model.query.QBoleta;
import io.ebean.Finder;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BoletaFinder extends Finder<Long, Boleta> {

    /**
     * The Constructor.
     */
    public BoletaFinder() {
        super(Boleta.class);
    }

    /**
     * Find all Boletas on the database by rut.
     * @param rut to use.
     * @return the list of Pagos.
     */
    public List<Boleta> byRut(@NotNull String rut) {
        return new QBoleta()
                .raw("contrato_id = (select id from contrato where persona_id = (select id from persona where rut = ?))", rut)
                .findList();
    }

}

