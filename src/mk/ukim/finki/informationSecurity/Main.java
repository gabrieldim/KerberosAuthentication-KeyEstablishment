package mk.ukim.finki.informationSecurity;
/**
 * Class for testing the application.
 * @author GABRIEL DIMITRIEVSKI
 */
public class Main {
    public static void main(String[] args) {
        KDCServer kdcServer = new KDCServer("informationSecurity42424324","laboratory1232442332");
        User Alice = new User("alice","IDalice","IDbob","informationSecurity42424324");
        User Bob = new User ("bob","IDbob","IDalice","laboratory1232442332");
        AnswerFromKDC answerFromKDC = kdcServer.RQST(Alice);
        yByABMessage yByABmessage = Alice.AliceVerification(answerFromKDC.getAnswerForBob(),
                                                            answerFromKDC.getAnswerForAlice());
        Bob.BobVerification(yByABmessage);
        System.out.println("===TESTING THE APPLICATION===");
        byte [] message = Alice.getMessage("Alice: Hey bob!");
        Bob.readMessage(message);
        System.out.println("===RETURN MESSAGE===");
        byte [] message2 = Bob.getMessage("Bob: Hey, what's up?");
        Alice.readMessage(message2);
        System.out.println("===END OF THE CHAT===");
    }
}
