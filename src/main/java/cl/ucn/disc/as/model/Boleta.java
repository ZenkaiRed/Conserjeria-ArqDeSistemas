package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.Instant;

/**
 * Clase Boleta
 */
@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
@Getter
public class Boleta extends BaseModel{

    @NotNull
    private Integer monto;

    @NotNull
    private Instant fechaPago;

    @ManyToOne
    private Contrato contrato;

}
