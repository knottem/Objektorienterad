package Sprint4.Uppgift9;

public class KnockKnockProtocol {

    private static final int WAITING = 0;
    private static final int SENTQUESTION = 1;
    private static final int ANSWER = 2;
    private static final int ANOTHER = 3;

    private static final int NUMJOKES = 3;

    private int state = WAITING;
    private int currentQuestion = 0;

    private final String[] questions = { "Vilken färg har solen?", "Är Stockholm sveriges Huvudstad", "Är Sverige med i EU?(2022)" };
    private final String[] answers = { "gul", "ja", "ja"};

    public String processInput(String theInput) {
        String theOutput = null;

        if (state == WAITING) {
            theOutput = "Hello, want a Question?";
            state = SENTQUESTION;
        } else if (state == SENTQUESTION) {
            if(theInput.equalsIgnoreCase("y")) {
                theOutput = questions[currentQuestion];
                state = ANSWER;
            }
        } else if (state == ANSWER) {
            if (theInput.equalsIgnoreCase(answers[currentQuestion])) {
                theOutput = "Rätt svar, Want another? (y/n)";
                state = ANOTHER;
            } else {
                theOutput = "Fel svar.";
                state = WAITING;
            }
        } else if (state == ANOTHER) {
            if (theInput.equalsIgnoreCase("y")) {
                theOutput = "want a Question?";
                if (currentQuestion == (NUMJOKES - 1))
                    currentQuestion = 0;
                else
                    currentQuestion++;
                state = SENTQUESTION;
            } else {
                theOutput = "Bye.";
                state = WAITING;
            }
        }
        return theOutput;
    }
}