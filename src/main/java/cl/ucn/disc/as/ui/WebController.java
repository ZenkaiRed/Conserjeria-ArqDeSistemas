package cl.ucn.disc.as.ui;

import cl.ucn.disc.as.grpc.PersonaGrpc;
import cl.ucn.disc.as.grpc.PersonaGrpcRequest;
import cl.ucn.disc.as.grpc.PersonaGrpcResponse;
import cl.ucn.disc.as.grpc.PersonaGrpcServiceGrpc;
import cl.ucn.disc.as.model.Persona;
import cl.ucn.disc.as.services.ISistema;
import cl.ucn.disc.as.services.Sistema;
import io.ebean.DB;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;

import java.util.Optional;

public final class WebController implements RoutesConfigurator {


    private final ISistema sistema;

    public WebController() {
        this.sistema = new Sistema(DB.getDefault());
        this.sistema.populate();
    }

    @Override
    public void configure(Javalin javalin) {

        javalin.get("/", ctx -> {
            ctx.result("Bienvenido a Conserjería API REST");
        });

        javalin.get("/personas", ctx -> {
            ctx.json(this.sistema.getPersonas());
        });

        javalin.get("/personas/rut/{rut}", ctx -> {
            String rut = ctx.pathParam("rut");
            Optional<Persona> oPersona = this.sistema.getPersona(rut);
            ctx.json(oPersona.orElseThrow(() -> new NotFoundResponse("No se pudo encontrar una persona con el rut: " + rut)));
        });

        javalin.get("/grpc/personas/rut/{rut}", ctx -> {
            String rut = ctx.pathParam("rut");

            ManagedChannel channel = ManagedChannelBuilder
                    .forAddress("localhost", 50123)
                    .usePlaintext()
                    .build();

            PersonaGrpcServiceGrpc.PersonaGrpcServiceBlockingStub stub =
                    PersonaGrpcServiceGrpc.newBlockingStub(channel);

            PersonaGrpcResponse response = stub.retrieve(PersonaGrpcRequest
                    .newBuilder()
                    .setRut(rut)
                    .build());

            PersonaGrpc personaGrpc = response.getPersona();

            Optional<Persona> oPersona = Optional.of(Persona.builder()
                    .rut(personaGrpc.getRut())
                    .nombre(personaGrpc.getNombre())
                    .apellidos(personaGrpc.getApellidos())
                    .email(personaGrpc.getEmail())
                    .telefono(personaGrpc.getTelefono())
                    .build());
            ctx.json(oPersona.orElseThrow(() -> new NotFoundResponse("No se pudo encontrar una persona con el rut: " + rut)));
        });






    }
}
