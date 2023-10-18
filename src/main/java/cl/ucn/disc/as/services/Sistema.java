package cl.ucn.disc.as.services;

import cl.ucn.disc.as.exceptions.SistemaException;
import cl.ucn.disc.as.model.*;
import io.ebean.Database;
import lombok.Builder;
import org.jetbrains.annotations.NotNull;

import javax.persistence.PersistenceException;
import java.time.Instant;
import java.util.List;

@Builder
public class Sistema implements ISistema{

    @NotNull
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
        try {
            this.database.save(persona);
        } catch (PersistenceException ex){
            throw new SistemaException("Error: " + ex.getMessage());
        }

        return persona;
    }

    @Override
    public Departamento agregarDepartamento(Departamento departamento, Edificio edificio) {

        try {
            edificio.getDepartamentos().add(departamento);
            this.database.save(edificio);

        } catch (PersistenceException ex){
            throw new SistemaException("Error: " + ex.getMessage());
        }

        return departamento;
    }

    @Override
    public Departamento agregarDepartamento(Departamento departamento, Long idEdificio) {

        try {

            Edificio edificio = this.buscarObjetoPorId(Edificio.class, idEdificio);
            edificio.getDepartamentos().add(departamento);
            this.database.save(edificio);

        } catch (PersistenceException ex){
            throw new SistemaException("Error: " + ex.getMessage());
        }

        return departamento;
    }

    @Override
    public Contrato realizarContrato(Persona duenio, Departamento departamento, Instant fechaPago) {

        Contrato contrato = Contrato.builder()
                .persona(duenio)
                .departamento(departamento)
                .fechaPago(fechaPago)
                .build();

        try {
            this.database.save(contrato);
        } catch (PersistenceException ex){
            throw new SistemaException("Error: " + ex.getMessage());
        }


        return contrato;
    }

    @Override
    public Contrato realizarContrato(Long idDuenio, Long idDepartamento, Instant fechaPago) {

        Contrato contrato;

        try {

            Departamento departamento = this.buscarObjetoPorId(Departamento.class, idDepartamento);

            Persona duenio = this.buscarObjetoPorId(Persona.class, idDuenio);

            contrato = Contrato.builder()
                    .persona(duenio)
                    .departamento(departamento)
                    .fechaPago(fechaPago)
                    .build();

            this.database.save(contrato);

        } catch (PersistenceException ex){
            throw new SistemaException("Error: " + ex.getMessage());
        }

        return contrato;

    }

    @Override
    public List<Contrato> getContratos() {

        List<Contrato> listaContratos;

        try {
            // Docs: https://ebean.io/docs/intro/database/
            listaContratos = this.database.find(Contrato.class).findList();
        } catch (PersistenceException ex){
            throw new SistemaException("Error: " + ex.getMessage());
        }

        return listaContratos;
    }

    @Override
    public List<Persona> getPersonas() {
        List<Persona> listaPersonas;

        try {
            // Docs: https://ebean.io/docs/intro/database/
            listaPersonas = this.database.find(Persona.class).findList();
        } catch (PersistenceException ex){
            throw new SistemaException("Error: " + ex.getMessage());
        }

        return listaPersonas;
    }

    @Override
    public List<Boleta> getPagos(String rut) {
        List<Boleta> listaBoletas;

        try {
            // Docs: https://ebean.io/docs/intro/database/
            listaBoletas = this.database.find(Boleta.class).findList();
        } catch (PersistenceException ex){
            throw new SistemaException("Error: " + ex.getMessage());
        }

        return listaBoletas;
    }


    /**
     * Método genérico para encontrar un objeto de la base de datos según la clase
     * a la que pertenece que a su vez hereda de BaseModel.
     * @param tipoDeClase Corresponde al tipo de clase al que corresponde.
     * @param id Corresponde al ID en la base de datos del objeto a buscar.
     * @return Retorna el objeto encontrado según su ID.
     * @param <T> Tipo de la clase el cual depende de la busqueda.
     */
    private <T extends BaseModel> T buscarObjetoPorId(Class<T> tipoDeClase, Long id) {

        // Puede ser cualquier objeto que extienda de BaseModel ^^
        T objeto;

        try {
            // Docs: https://ebean.io/docs/intro/database/
            objeto = this.database.find(tipoDeClase, id);

        } catch (PersistenceException ex){

            throw new SistemaException("Error: " + ex.getMessage());
        }

        return objeto;
    }

}
