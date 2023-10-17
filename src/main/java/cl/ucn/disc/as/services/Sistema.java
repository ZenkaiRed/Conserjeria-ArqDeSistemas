package cl.ucn.disc.as.services;

import cl.ucn.disc.as.exceptions.SistemaException;
import cl.ucn.disc.as.model.Contrato;
import cl.ucn.disc.as.model.Departamento;
import cl.ucn.disc.as.model.Edificio;
import cl.ucn.disc.as.model.Persona;
import io.ebean.Database;
import org.jetbrains.annotations.NotNull;

import javax.persistence.PersistenceException;
import java.time.Instant;
import java.util.List;

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
            throw new SistemaException("Error: " + ex.getMessage());
        }

        return edificio;
    }

    @Override
    public Persona agregar(Persona persona) {
        return null;
    }

    @Override
    public Departamento agregarDepartamento(Departamento departamento, Edificio edificio) {
        return null;
    }

    @Override
    public Departamento agregarDepartamento(Departamento departamento, Long idEdificio) {
        return null;
    }

    @Override
    public Contrato realizarContrato(Persona duenio, Departamento departamento, Instant fechaPago) {
        return null;
    }

    @Override
    public Contrato realizarContrato(Long idDuenio, Long idDepartamento, Instant fechaPago) {
        return null;
    }

    @Override
    public List<Contrato> getContratos() {
        return null;
    }

    @Override
    public List<Persona> getPersonas() {
        return null;
    }

    @Override
    public List<Contrato> getPagos(String rut) {
        return null;
    }
}
