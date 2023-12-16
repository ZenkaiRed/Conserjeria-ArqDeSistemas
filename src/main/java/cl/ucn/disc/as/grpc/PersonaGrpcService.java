package cl.ucn.disc.as.grpc;

import cl.ucn.disc.as.grpc.PersonaGrpcServiceGrpc;
import cl.ucn.disc.as.services.Sistema;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class PersonaGrpcService extends PersonaGrpcServiceGrpc.PersonaGrpcServiceImplBase {
    @Override
    public void retrieve(PersonaGrpcRequest request, StreamObserver<PersonaGrpcResponse> responseObserver) {
        log.debug("Recuperando Persona con RUT: {}", request.getRut());
        PersonaGrpc personaGrpc = PersonaGrpc.newBuilder()
                .setRut(request.getRut())
                .setNombre("Marcelo")
                .setApellidos("Céspedes")
                .setEmail("marcelo.cespedes@alumnos.ucn.cl")
                .setTelefono("+56977404965")
                .build();

        responseObserver.onNext(PersonaGrpcResponse.newBuilder()
                .setPersona(personaGrpc)
                .build());
        responseObserver.onCompleted();
    }

}
