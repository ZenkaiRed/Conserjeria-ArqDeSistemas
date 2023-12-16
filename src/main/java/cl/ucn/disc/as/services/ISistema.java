package cl.ucn.disc.as.services;

import cl.ucn.disc.as.model.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface ISistema {

    /**
     * Agrega un nuevo edificio al sistema.
     * @param edificio Corresponde al edificio a agregar.
     */
    Edificio agregar(Edificio edificio);

    Persona agregar(Persona persona);

    Departamento agregarDepartamento(Departamento departamento, Edificio edificio);

    Departamento agregarDepartamento(Departamento departamento, Long idEdificio);

    Contrato realizarContrato(Persona duenio, Departamento departamento, Instant fechaPago);

    Contrato realizarContrato(Long idDuenio, Long idDepartamento, Instant fechaPago);

    List<Contrato> getContratos();

    List<Persona> getPersonas();

    Optional<Persona> getPersona(String rut);

    List<Boleta> getPagos(String rut);

    public void populate();

}
