package cl.ucn.disc.as;

import cl.ucn.disc.as.grpc.PersonaGrpcService;
import cl.ucn.disc.as.ui.ApiRestServer;
import cl.ucn.disc.as.ui.WebController;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public final class Main {

    public static void main(String[] args) throws IOException, InterruptedException{

        log.debug("Starting main...");

        ApiRestServer.start(5000, new WebController());

        log.debug("Done API Start.");

        log.debug("Starting the gRPC server...");
        Server server = ServerBuilder
                .forPort(50123)
                .addService(new PersonaGrpcService())
                .build();
        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdown));
        server.awaitTermination();
        log.debug("Done.");

    }

}
