package mk.ukim.finki.informationSecurity.Exceptions;
/**
 * This exception is thrown when the nonce values are different.
 */
public class NonceIsDifferentException extends RuntimeException {
    public NonceIsDifferentException() {
        super("Nonce value is different!");
    }
}
