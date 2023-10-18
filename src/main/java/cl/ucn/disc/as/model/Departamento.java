package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
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

    @ManyToOne
    private Edificio edificio;

}
