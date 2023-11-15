package cl.ucn.disc.as;

import cl.ucn.disc.as.ui.ApiRestServer;
import cl.ucn.disc.as.ui.WebController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class Main {

    public static void main(String[] args) {

        log.debug("Starting main...");

        ApiRestServer.start(5000, new WebController());

        log.debug("Done...");

        /*
        Database db = DB.getDefault();

        ISistema sistema = new Sistema(db);

        Edificio edificio = Edificio.builder()
                .nombre("Y1")
                .direccion("Angamos #0610")
                .build();

        log.debug("Edificio antes de la bd: {}", edificio);

        edificio = sistema.agregar(edificio);

        log.debug("Edificio después de la bd: {}", edificio);




        try {
            persona = Persona.builder()
                    .rut("20723668-3")
                    .nombre("Marcelo")
                    .apellidos("Cespedes Arqueros")
                    .email("m.cespedes.arq@gmail.com")
                    .telefono("+56977404965")
                    .build();
        }
        catch (Exception e){
            log.debug(e.getMessage());
        }


        log.debug("La Persona antes de la db: ${}", persona);

        db.save(persona);

        log.debug("La Persona desde la db: ${}", persona);

        log.debug("Done. :)");
        */


    }

}
