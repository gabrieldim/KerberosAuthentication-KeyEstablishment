package mk.ukim.finki.informationSecurity;

/**
 * We are using this class to make an object so we can send the data from Alice to Bob.
 */
public class yByABMessage {
    private byte[] cipheredIDA;
    private byte[] cipheredTimestamp;
    private AnswerForBob answerForBob;

    public yByABMessage(byte[] cipheredIDA, byte[] cipheredTimestamp, AnswerForBob answerForBob) {
        this.cipheredIDA = cipheredIDA;
        this.cipheredTimestamp = cipheredTimestamp;
        this.answerForBob = answerForBob;
    }

    public yByABMessage() { }

    public AnswerForBob getAnswerForBob() {
        return answerForBob;
    }

    public void setAnswerForBob(AnswerForBob answerForBob) {
        this.answerForBob = answerForBob;
    }

    public byte[] getCipheredIDA() {
        return cipheredIDA;
    }

    public void setCipheredIDA(byte[] cipheredIDA) {
        this.cipheredIDA = cipheredIDA;
    }

    public byte[] getCipheredTimestamp() {
        return cipheredTimestamp;
    }

    public void setCipheredTimestamp(byte[] cipheredTimestamp) {
        this.cipheredTimestamp = cipheredTimestamp;
    }
}
