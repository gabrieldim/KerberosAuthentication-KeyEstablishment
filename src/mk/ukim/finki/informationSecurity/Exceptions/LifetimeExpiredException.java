package mk.ukim.finki.informationSecurity.Exceptions;

/**
 * This exception is thrown when the lifetime has expired.
 */
public class LifetimeExpiredException extends RuntimeException {
    public LifetimeExpiredException() {
        super("Lifetime has expired!");
    }
}
