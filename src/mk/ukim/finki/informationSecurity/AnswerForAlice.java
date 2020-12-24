package mk.ukim.finki.informationSecurity;

/**
 * This class contains the data that Alice need to receive.
 */
public class AnswerForAlice {
    private byte [] cipheredSessionKey;
    private byte [] cipheredNonceA;
    private byte [] cipheredTime;
    private byte [] cipheredIDBob;

    public AnswerForAlice(byte[] cipheredSessionKey, byte[] cipheredNonceA, byte[] cipheredTime, byte[] cipheredIDBob) {
        this.cipheredSessionKey = cipheredSessionKey;
        this.cipheredNonceA = cipheredNonceA;
        this.cipheredTime = cipheredTime;
        this.cipheredIDBob = cipheredIDBob;
    }

    public AnswerForAlice() {
    }

    public byte[] getCipheredSessionKey() {
        return cipheredSessionKey;
    }

    public void setCipheredSessionKey(byte[] cipheredSessionKey) {
        this.cipheredSessionKey = cipheredSessionKey;
    }

    public byte[] getCipheredNonceA() {
        return cipheredNonceA;
    }

    public void setCipheredNonceA(byte[] cipheredNonceA) {
        this.cipheredNonceA = cipheredNonceA;
    }

    public byte[] getCipheredTime() {
        return cipheredTime;
    }

    public void setCipheredTime(byte[] cipheredTime) {
        this.cipheredTime = cipheredTime;
    }

    public byte[] getCipheredIDBob() {
        return cipheredIDBob;
    }

    public void setCipheredIDBob(byte[] cipheredIDBob) {
        this.cipheredIDBob = cipheredIDBob;
    }
}
