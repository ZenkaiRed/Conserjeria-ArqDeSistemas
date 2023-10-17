package cl.ucn.disc.as.services;

import cl.ucn.disc.as.exceptions.SistemaException;
import cl.ucn.disc.as.model.Edificio;
import cl.ucn.disc.as.model.Persona;
import io.ebean.Database;
import org.jetbrains.annotations.NotNull;

import javax.persistence.PersistenceException;

public class Sistema implements ISistema{

    private final Database database;

    /**
     * Constructor de la clase Sistema.
     * @param database Base de datos a utilizar.
     */
    public Sistema(@NotNull Database database) {
        this.database = database;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Edificio agregar(Edificio edificio) {
        try {
            this.database.save(edificio);
        } catch (PersistenceException ex){
            throw new SistemaException("Error: ", ex);
        }

        return edificio;
    }

    @Override
    public void agregar(Persona persona) {

    }
}
