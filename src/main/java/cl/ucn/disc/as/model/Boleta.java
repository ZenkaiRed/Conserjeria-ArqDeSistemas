package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

/**
 * Clase Boleta
 */
@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
public class Boleta extends BaseModel{

    @NotNull
    private Integer monto;

    @NotNull
    private LocalDate fechaFacturacion;

    @NotNull
    private LocalDate fechaCorte;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

}
