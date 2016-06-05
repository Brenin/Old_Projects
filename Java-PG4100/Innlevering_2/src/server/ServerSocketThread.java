package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

import quiz.Question;
import quiz.Protocol;
import util.ConnectToDB;

/**
 * Created by Eirikur Lundin
 */
public class ServerSocketThread extends Thread{
    
    Socket socket;
    ConnectToDB dbCon;
    Question[] questions;

    /**
     * Constructor
     * @param socket
     * @param dbCon
     */
    public ServerSocketThread(Socket socket, ConnectToDB dbCon) {
        super();
        this.socket = socket;
        this.dbCon = dbCon;
        questions = new Question().getInstances(dbCon);
    }

    /**
     * Creates the thread run process every time a client connect to the server. *
     */
    public void run(){
        try (PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));){

            Protocol quizProtocol = new Protocol(questions);
            String userAnswer = null;
            
            while ( !quizProtocol.isCloseConnection() ) {
                output.println(quizProtocol.getAnswer(userAnswer));
                userAnswer = input.readLine();
            }

        } catch (SocketException e){
            System.out.println("Connection lost");
        } catch (IOException e) {
            System.out.println("Error in communication");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Error, closing the socket");
            }
        }
    }
}
