package cl.ucn.disc.as.ui;

import cl.ucn.disc.as.services.ISistema;
import cl.ucn.disc.as.services.Sistema;
import io.ebean.DB;
import io.javalin.Javalin;

public final class WebController implements RoutesConfigurator {


    private final ISistema sistema;

    public WebController() {
        this.sistema = new Sistema(DB.getDefault());
    }

    @Override
    public void configure(Javalin javalin) {

        javalin.get("/", ctx -> {
            ctx.result("Bienvenido a Conserjería API REST");
        });

        javalin.get("/personas", ctx -> {
            ctx.json(sistema.getPersonas());
        });

    }
}
