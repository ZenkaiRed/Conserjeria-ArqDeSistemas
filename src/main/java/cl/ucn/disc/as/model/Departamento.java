package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Clase Departamento
 */
@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
public class Departamento extends BaseModel{

    @NotNull
    private Integer numeroPiso;

    @NotNull
    private String piso;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_propietario")
    private Persona propietario;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_edificio")
    private Edificio edificio;

    @NotNull
    @OneToMany(mappedBy = "departamento")
    private List<Boleta> gastosComunes;

}
