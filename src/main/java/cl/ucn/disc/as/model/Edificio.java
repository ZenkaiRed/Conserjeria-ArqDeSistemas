package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Clase Edificio.
 */
@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class Edificio extends BaseModel{

    @NotNull
    private String nombre;

    @NotNull
    private String direccion;

    @OneToMany(mappedBy = "edificio")
    private List<Departamento> departamentos;

}
