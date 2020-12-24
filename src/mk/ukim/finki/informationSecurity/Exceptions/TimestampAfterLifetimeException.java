package mk.ukim.finki.informationSecurity.Exceptions;
/**
 * This exception is thrown when the timestamp value is after the lifetime.
 */
public class TimestampAfterLifetimeException extends RuntimeException {
    public TimestampAfterLifetimeException() {
        super("Timestamp is after the lifetime!");
    }
}
