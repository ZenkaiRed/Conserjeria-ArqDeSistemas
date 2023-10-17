package cl.ucn.disc.as.model.exception;

/**
 * @author Marcelo Céspedes Arqueros.
 */
public class IllegalDomainException extends RuntimeException {

    /**
     * Constructor.
     * @param message Exception message.
     */
    public IllegalDomainException(String message) {
        super(message);
    }
}
