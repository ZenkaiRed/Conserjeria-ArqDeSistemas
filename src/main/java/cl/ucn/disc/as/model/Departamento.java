package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

import javax.persistence.Entity;

@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
public class Departamento extends BaseModel{

    /**
     * Número del piso del departamento.
     */
    @NotNull
    private Integer numeroPiso;

    /**
     * Piso del departamento.
     */
    @NotNull
    private String piso;

}
