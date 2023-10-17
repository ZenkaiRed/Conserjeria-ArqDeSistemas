package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;


@AllArgsConstructor
@Builder
@Entity
@Getter
public class Contrato extends BaseModel {


    @NotNull
    private Instant fechaPago;

    @NotNull
    @ManyToOne
    private Persona persona;

    @NotNull
    @ManyToOne
    private Departamento departamento;

    @NotNull
    @OneToMany(mappedBy = "contrato")
    private List<Boleta> pagos;
}