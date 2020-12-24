package mk.ukim.finki.informationSecurity;
/**
 * This class contains the data that Bob need to receive.
 */
public class AnswerForBob {
    private byte [] cipheredSessionKey;
    private byte [] cipheredIDAlice;
    private byte [] cipheredTime;

    public AnswerForBob(byte[] cipheredSessionKey, byte[] cipheredIDAlice, byte[] cipheredTime) {
        this.cipheredSessionKey = cipheredSessionKey;
        this.cipheredIDAlice = cipheredIDAlice;
        this.cipheredTime = cipheredTime;
    }

    public AnswerForBob() {
    }

    public byte[] getCipheredSessionKey() {
        return cipheredSessionKey;
    }

    public void setCipheredSessionKey(byte[] cipheredSessionKey) {
        this.cipheredSessionKey = cipheredSessionKey;
    }

    public byte[] getCipheredIDAlice() {
        return cipheredIDAlice;
    }

    public void setCipheredIDAlice(byte[] cipheredIDAlice) {
        this.cipheredIDAlice = cipheredIDAlice;
    }

    public byte[] getCipheredTime() {
        return cipheredTime;
    }

    public void setCipheredTime(byte[] cipheredTime) {
        this.cipheredTime = cipheredTime;
    }
}
