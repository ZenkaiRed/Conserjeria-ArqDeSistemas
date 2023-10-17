package cl.ucn.disc.as.services;

import cl.ucn.disc.as.model.Edificio;
import cl.ucn.disc.as.model.Persona;

public interface ISistema {

    /**
     * Agrega un nuevo edificio al sistema.
     * @param edificio Corresponde al edificio a agregar.
     */
    Edificio agregar(Edificio edificio);

    void agregar(Persona persona);



}
