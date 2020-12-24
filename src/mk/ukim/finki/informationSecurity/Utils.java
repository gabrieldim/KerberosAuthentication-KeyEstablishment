package mk.ukim.finki.informationSecurity;

import java.security.SecureRandom;
import java.sql.Time;
import java.util.Random;

/**
 * Utils class contains the methods that are used once or potentially more times in a different classes
 * and are better for just call some of the methods than making copy-paste on the same code.
 */
public class Utils {
    /**
     * Generating the random value for a session key.
     *
     * @return byte[].
     */
    public static byte[] generateSessionKey() {
        Random randomNumber = new Random();
        byte[] randomSessionKey = new byte[16];
        randomNumber.nextBytes(randomSessionKey);
        return randomSessionKey;
    }

    /**
     * The lifetime limit of the key.
     *
     * @return Time.
     */
    public static Time generateLifetime(){
            return new Time(System.currentTimeMillis() + (300*10*1000));
    }

    /**
     * Generating random number(nonce- number used only once).
     *
     * @return byte[].
     */
    public static byte[] generateRandomNonce(){
        byte [] bytes = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(bytes);
        return bytes;
    }

    /**
     * Whenever we need current time we can use this method.
     *
     * @return Time.
     */
    public static Time generateTimestamp(){
       return new Time(System.currentTimeMillis());
    }
}
