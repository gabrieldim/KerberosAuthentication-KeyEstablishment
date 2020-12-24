package mk.ukim.finki.informationSecurity.Exceptions;
/**
 * This exception is thrown when the ID's from the users are not equal.
 */
public class UsersIDNotValidException extends RuntimeException {
    public UsersIDNotValidException() {
        super("Users ID's are different!");
    }
}