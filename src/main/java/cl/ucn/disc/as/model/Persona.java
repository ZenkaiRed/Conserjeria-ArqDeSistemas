/*
 * Copyright (c) 2023. Arquitectura de Sistemas, DISC, UCN.
 */

package cl.ucn.disc.as.model;

import cl.ucn.disc.as.exceptions.IllegalDomainException;
import cl.ucn.disc.as.utils.ValidationUtils;
import io.ebean.annotation.NotNull;
import lombok.*;

import javax.persistence.Entity;

/**
 * The Persona class.
 *
 * @author Diego Urrutia-Astorga.
 */
@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class Persona extends BaseModel {

    /**
     * The RUT.
     */
    @NotNull
    private String rut;

    /**
     * The Nombre.
     */
    @NotNull
    private String nombre;

    /**
     * The Apellidos.
     */
    @NotNull
    private String apellidos;

    /**
     * The Email.
     */
    @NotNull
    private String email;

    /**
     * The Telefono.
     */
    @NotNull
    private String telefono;

    /**
     * Custom builder to validate.
     */
    public static class PersonaBuilder{

        /**
         * @return Persona.
         */
        public Persona build(){

            // Validate rut

            if (!ValidationUtils.isRutValid(this.rut)){
                throw new IllegalDomainException("Rut no válido: " + this.rut);
            }

            // Validate email

            if (!ValidationUtils.isEmailValid(this.email)){
                throw new IllegalDomainException("Email no válido: " + this.email);
            }

            // TODO: agregar resto de validaciones

            return new Persona(this.rut, this.nombre, this.apellidos, this.email, this.telefono);

        }


    }



}
