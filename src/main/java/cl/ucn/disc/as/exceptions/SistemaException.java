package cl.ucn.disc.as.exceptions;

import javax.persistence.PersistenceException;

public class SistemaException extends RuntimeException {
    public SistemaException(String message, PersistenceException ex) {
        super(message);
    }
}
