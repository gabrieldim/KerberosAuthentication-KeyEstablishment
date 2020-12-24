package mk.ukim.finki.informationSecurity;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Advanced Encryption Standard
 */
public class AESEncryptDecryptMessage {

    private SecretKeySpec secretKey;
    private  byte[] key;

    /**
     * This mehtod is decrypting the byte array that recieves as a parametar.
     *
     * @param byteArr decrypting array.
     * @return byte[].
     */
    public byte[] decrypt(byte[] byteArr)
    {
        try
        {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return cipher.doFinal(byteArr);
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    /**
     * This mehtod is encrypting the byte array that recieves as a parametar.
     *
     * @param byteArr encrypting array.
     * @return byte [].
     */
    public byte[] encrypt(byte[] byteArr)
    {
        try
        {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(byteArr);
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    /**
     * This method is setting the Key of the AES.
     *
     * @param myKey is the value of the key.
     */
    public void setKey(String myKey)
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-256");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
