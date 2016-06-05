package quiz;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Eirikur Lundin
 *
 * This class defines the protocol server, it evaluates the users' requests.
 */
public class Protocol {

    private State state = State.HELLO;
    private boolean closeCon;
    private Question[] questions;
    private boolean[] askedQuestions;

    public Protocol(Question[] questionsToAsk) {
        closeCon = false;
        questions = questionsToAsk;
        askedQuestions = new boolean[questionsToAsk.length];
    }

    /**
     * It handles the answer of the users, and gives the answer according to the state.*
     * @param userAnswer 
     * @return
     */
    public String getAnswer(String userAnswer) {
        if ( userAnswer != null ){
            userAnswer = userAnswer.toLowerCase();
        }

        if (state == State.HELLO) {
            if ( userAnswer == null ){
                return "Will you participate in our QUIZ? (Yes / no)";
            }else if ( userAnswer.equals("no") || userAnswer.equals("n") ) {
                state = State.EXITING;
                return message();
            }else if ( userAnswer.equals("y") || userAnswer.equals("yes") ){
                state = State.PARTICIPATE;
                return getQuestionToAsk();
            }else{
                return "Incorrect option. Please try again. \nWill you participate in writer-QUIZ? (Yes / no)";
            }

        } else if (state == State.PARTICIPATE) {
            if ( userAnswer.equals("bye") ){
                state = State.EXITING;
                return message();
            }else if(userAnswer.equals("no_option")){
                state = State.HELLO;
                return "Incorrect option. Please try again. Will you participate in writer-QUIZ? (Yes / no)";
            }else{
                return getQuestionToAsk();
            }
        } else if (state == State.EXITING) {
            closeCon = true;
            return "";
        }
        return "";
    }
    
    private String getQuestionToAsk() {
        int questionIndex = getQuestionIndex();
        askedQuestions[questionIndex] = true;
        return questions[questionIndex].toString();
    }

    private String message() {
        return "Thank you for participating in our quiz, bye";
    }

    public boolean isCloseConnection() {
        return closeCon;
    }
    
    /**
     * Using a random generator, we get a valid index from the available question.*
     * @return
     */
    public int getQuestionIndex(){
        ArrayList<Integer> availableQuestions = new ArrayList<>();
        for (int i = 0; i < askedQuestions.length; i++) {
            if ( !askedQuestions[i] ){
                availableQuestions.add(i);
            }
        }
        Random rnd = new Random();
        return availableQuestions.get(rnd.nextInt(availableQuestions.size()));
    }

    public void setState(State currentState) {
        this.state = currentState;
    }

    public State getState() {
        return state;
    }
}
