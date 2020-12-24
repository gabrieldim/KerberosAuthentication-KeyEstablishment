package mk.ukim.finki.informationSecurity;

import java.sql.Time;

/**
 *  key distribution center
 */
public class KDCServer {
    private String keyAlice;
    private String keyBob;
    public KDCServer(String keyAlice, String keyBob) {
        this.keyAlice = keyAlice;
        this.keyBob = keyBob;
    }

    /**
     *  This method is sending the data from Alice to KDC server.
     *
     * @param user an object from the class User with the basic data that we need to establish authentication.
     * @return AnswerFromKDC.
     */
    public AnswerFromKDC RQST(User user){
        byte [] randomSessionKey = Utils.generateSessionKey();
        Time lifetime = Utils.generateLifetime();

        AESEncryptDecryptMessage aesAlice = new AESEncryptDecryptMessage();
        aesAlice.setKey(this.keyAlice);
        byte [] cipheredSessionKeyAlice= aesAlice.encrypt(randomSessionKey);
        byte [] cipheredNonceA= aesAlice.encrypt(user.getNonce());
        byte [] cipheredTimeAlice= aesAlice.encrypt(String.valueOf(lifetime.getTime()).getBytes());
        byte [] cipheredIDBob= aesAlice.encrypt(user.getSecoundUserId().getBytes());
        AnswerForAlice answerForAlice = new AnswerForAlice(cipheredSessionKeyAlice,cipheredNonceA,
                cipheredTimeAlice,cipheredIDBob);

        AESEncryptDecryptMessage aesBob = new AESEncryptDecryptMessage();
        aesBob.setKey(this.keyBob);
        byte [] cipheredSessionKeyBob = aesBob.encrypt(randomSessionKey);
        byte [] cipheredIDA = aesBob.encrypt(user.getID().getBytes());
        byte [] cipheredTimeBob =aesBob.encrypt(String.valueOf(lifetime.getTime()).getBytes());
        AnswerForBob answerForBob = new AnswerForBob(cipheredSessionKeyBob,cipheredIDA,cipheredTimeBob);

        AnswerFromKDC answerFromKDC = new AnswerFromKDC(answerForBob,answerForAlice);
        return answerFromKDC;
    }
}