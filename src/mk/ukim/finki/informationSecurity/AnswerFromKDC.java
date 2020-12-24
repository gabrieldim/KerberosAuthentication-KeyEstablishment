package mk.ukim.finki.informationSecurity;
/**
 * This class contains the data that Alice need to receive.
 * The data is made of the different classes.
 */
public class AnswerFromKDC {
    private AnswerForBob answerForBob;
    private AnswerForAlice answerForAlice;

    public AnswerFromKDC(AnswerForBob answerForBob, AnswerForAlice answerFromAlice) {
        this.answerForBob = answerForBob;
        this.answerForAlice = answerFromAlice;
    }

    public AnswerFromKDC() {
    }

    public AnswerForBob getAnswerForBob() {
        return answerForBob;
    }

    public void setAnswerForBob(AnswerForBob answerForBob) {
        this.answerForBob = answerForBob;
    }

    public AnswerForAlice getAnswerForAlice() {
        return answerForAlice;
    }

    public void setAnswerForAlice(AnswerForAlice answerForAlice) {
        this.answerForAlice = answerForAlice;
    }
}
