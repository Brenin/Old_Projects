package client;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import quiz.Question;


/**
 * Created by Eirikur Lundin
 */
public class ClientSocketQuiz {
	
    /**
     * Main execution method for the quiz client
     * @param args
     */
    public static void main(String[] args) {

		String serverIp = "127.0.0.1";
		int serverPort = 3010;

        String goodByeMessage = "Goodbye and thank you for participating";
		try (Scanner sc = new Scanner(System.in);
				Socket serverCon = new Socket(serverIp, serverPort);
				PrintWriter output = new PrintWriter(serverCon.getOutputStream(), true);
				BufferedReader input = new BufferedReader (new InputStreamReader(serverCon.getInputStream()));){
            
			String answer;
			
            while ( !(answer = input.readLine()).equals(goodByeMessage) ){
                // Let's ask a question
                if ( answer.startsWith("QUESTION") ){
                    answer = answer.substring("QUESTION".length());
                    String[] questionTokens = answer.split("####");
                    
                    // Lets parse the question, and lets create the object question.
                    Question question = new Question(questionTokens[0], questionTokens[1], questionTokens[2],
                        Integer.parseInt(questionTokens[3]),  Integer.parseInt(questionTokens[4]));
                    System.out.println("Who wrote " + question.getTittel() + "?");

                    String userMessage = sc.nextLine().toLowerCase();
                    
                    // Check for right answer
                    String forfatter = question.getForfatter();
                    if ( isCorrect(forfatter, userMessage) ){
                        System.out.println("Correct!");
                    }else{
                        System.out.println("Incorrect :( The answer is " + forfatter);
                    }
                    
                    System.out.println("Would you like to continue (y/n)");
                    
                    userMessage = sc.nextLine().toLowerCase();
                    
                    if ( userMessage.equals("n") || userMessage.equals("no") ){
                        output.println("bye");
                    }else if( userMessage.equals("y") || userMessage.equals("yes") ){
                        output.println("continue");
                    }else{
                        output.println("no_option");
                    }
                }else{
                    // if we are not asking questions, lets just print the server's messages.
                    System.out.println(answer);
                    output.println(sc.nextLine());
                }
			}
            System.out.println(goodByeMessage);
            
		} catch (UnknownHostException e) {
            System.out.println("IUnable to connect to the database");
        } catch (IOException e) {
            System.out.println("Not possible to connect to the port");
        }
    }

    /**
     * Returns true if the arguments are 'similar' *
     * @param correctAnswer Correct answer.
     * @param userAnswer This is the user's answer.
     * @return true if they are both similar
     */
    public static boolean isCorrect(String correctAnswer, String userAnswer){
        String userFormattedAnswer = formatAnswer(userAnswer.toLowerCase());
        String correctFormattedAnswer = formatAnswer(correctAnswer.toLowerCase());

        List<String> correctTokens = new ArrayList<>();
        List<String> userTokens = new ArrayList<>();
        for( String s : correctFormattedAnswer.split(" ") ){
            correctTokens.add(s);
        }
        for( String s : userFormattedAnswer.split(" ") ){
            userTokens.add(s);
        }
        
        Collections.sort(userTokens);
        Collections.sort(correctTokens);
        
        return userTokens.equals(correctTokens);
    }

    /**
     * Removes the special characters from a string *
     * @param userAnswer string to be formatted
     * @return String formatted
     */
    private static String formatAnswer(String userAnswer) {
        StringBuilder sb = new StringBuilder();
        for ( char c : userAnswer.toCharArray() ){
            if ( ('a' <= c && c <= 'z') || c == ' ' ){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
