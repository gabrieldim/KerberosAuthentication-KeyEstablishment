package mk.ukim.finki.informationSecurity;

import mk.ukim.finki.informationSecurity.Exceptions.LifetimeExpiredException;
import mk.ukim.finki.informationSecurity.Exceptions.NonceIsDifferentException;
import mk.ukim.finki.informationSecurity.Exceptions.TimestampAfterLifetimeException;
import mk.ukim.finki.informationSecurity.Exceptions.UsersIDNotValidException;

import java.sql.Time;
import java.util.Arrays;

/**
 * User class contains the data from the users that are part of the testing. The users that i made, so i can
 * try to test this application and see if it works properly.
 */
public class User {
    private String username;
    private String secoundUserId;
    private byte [] sessionKey;
    private byte [] nonce;
    private String ID;
    private String key;

    /**
     * Constructor with parameters.
     *
     * @param username of the user.
     * @param ID of the user.
     * @param secoundUserId of the user.
     * @param key of the user.
     */
    public User(String username, String ID, String secoundUserId, String key) {
        this.username = username;
        this.secoundUserId = secoundUserId;
        this.ID = ID;
        this.key = key;
        this.nonce = new byte[16];
       this.nonce= Utils.generateRandomNonce();
    }

    /**
     * We need this method for verification on the side of Alice. It is making decryption of the object and few
     * if-statements for authentication purposes. After those checks, make a proper object.
     *
     * @param answerForBob object from the class AnswerForBob.
     * @param answerForAlice object from the class AnswerForAlice.
     * @return yByABMessage.
     */
    public yByABMessage AliceVerification(AnswerForBob answerForBob, AnswerForAlice answerForAlice){
        AESEncryptDecryptMessage aesAlice = new AESEncryptDecryptMessage();
        aesAlice.setKey(this.key);
        byte [] decryptedSessionKey = aesAlice.decrypt(answerForAlice.getCipheredSessionKey());
        byte [] decryptedNonceA = aesAlice.decrypt(answerForAlice.getCipheredNonceA());
        byte [] decryptedLifeTime = aesAlice.decrypt(answerForAlice.getCipheredTime());
        byte [] decryptedIDBob = aesAlice.decrypt(answerForAlice.getCipheredIDBob());

        this.sessionKey=decryptedSessionKey;

        String lifetime = new String(decryptedLifeTime);
        Time time = new Time(Long.parseLong(lifetime));
        Time atThisMoment = new Time(System.currentTimeMillis());

        if(!Arrays.equals(nonce,decryptedNonceA)){
            throw new NonceIsDifferentException();
        }
        String decryptedIDB = new String(decryptedIDBob);
        if(!secoundUserId.equals(decryptedIDB)){
            throw new UsersIDNotValidException();
        }
        if(atThisMoment.after(time)){
            throw new LifetimeExpiredException();
        }

        Time timestamp = Utils.generateTimestamp();

        AESEncryptDecryptMessage aesSession = new AESEncryptDecryptMessage();
        String SessionKey = new String(decryptedSessionKey);
        aesSession.setKey(SessionKey);

        byte[] cipheredIDA = aesSession.encrypt(ID.getBytes());
        byte[] cipheredTimestamp = aesSession.encrypt(String.valueOf(timestamp.getTime()).getBytes());

        yByABMessage yByABmessage = new yByABMessage(cipheredIDA,cipheredTimestamp,answerForBob);
        return yByABmessage;
    }

    /**
     * We need this method for verification on the side of Bob. It is making decryption of the object and few
     * if-statements for authentication purposes.
     *
     * @param yByABmessage obect from the class yByABMessage
     */
    public void BobVerification(yByABMessage yByABmessage){
        AESEncryptDecryptMessage aesBob = new AESEncryptDecryptMessage();
        aesBob.setKey(key);
        byte [] decryptedSessionKey = aesBob.decrypt(yByABmessage.getAnswerForBob().getCipheredSessionKey());
        byte [] decryptedIDAlice = aesBob.decrypt(yByABmessage.getAnswerForBob().getCipheredIDAlice());
        byte [] decryptedTime = aesBob.decrypt(yByABmessage.getAnswerForBob().getCipheredTime());

        this.sessionKey = decryptedSessionKey;
        String lifetimeString = new String(decryptedTime);
        Time lifetime = new Time(Long.valueOf(lifetimeString));

        AESEncryptDecryptMessage aesSession = new AESEncryptDecryptMessage();
        String sessionKeyString = new String(sessionKey);
        aesSession.setKey(sessionKeyString);

       byte [] decryptedIDA = aesSession.decrypt(yByABmessage.getCipheredIDA());
       byte [] decryptedTimestamp = aesSession.decrypt(yByABmessage.getCipheredTimestamp());

       if(!Arrays.equals(decryptedIDA,decryptedIDAlice)){
           throw new UsersIDNotValidException();
       }
       Time atThisMoment = new Time(System.currentTimeMillis());
       if(atThisMoment.after(lifetime)){
           throw new LifetimeExpiredException();
       }

        String timestampString = new String(decryptedTimestamp);
        Time timestamp = new Time(Long.valueOf(timestampString));
       if(timestamp.after(lifetime)){
           throw new TimestampAfterLifetimeException();
       }
    }

    /**
     * After making sure that everything is okay between those two sides i'm trying to send data from and check if it
     * works.
     *
     * @param message message that is sending from one to another side.
     * @return byte[].
     */
    public byte[] getMessage(String message){
        AESEncryptDecryptMessage aes = new AESEncryptDecryptMessage();
        String keyString = new String(sessionKey);
        aes.setKey(keyString);
        return aes.encrypt(message.getBytes());
    }

    /**
     * Method used only for printing the data on the terminal.
     *
     * @param message message that the user is receiving.
     */
    public void readMessage(byte [] message){
        AESEncryptDecryptMessage aes = new AESEncryptDecryptMessage();
        String keyString = new String(sessionKey);
        aes.setKey(keyString);
        byte []decryptedMessage = aes.decrypt(message);
        String printMessage = new String(decryptedMessage);
        System.out.println(printMessage);
    }

    /**
     * GETTERS AND SETTERS
     *
     */
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getSecoundUserId() {
        return secoundUserId;
    }
    public void setSecoundUserId(String secoundUserId) {
        this.secoundUserId = secoundUserId;
    }
    public byte[] getSessionKey() {
        return sessionKey;
    }
    public void setSessionKey(byte[] sessionKey) {
        this.sessionKey = sessionKey;
    }
    public byte[] getNonce() {
        return nonce;
    }
    public void setNonce(byte[] nonce) {
        this.nonce = nonce;
    }
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
}
