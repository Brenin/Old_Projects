package server;

import java.io.*;
import java.net.*;
import java.sql.SQLException;

import util.ConnectToDB;

/**
 * Created by Eirikur Lundin
 */
public class ServerSocketQuiz {

	/**
	 * Main execution method for the quiz server
	 * @param args
     */
	public static void main(String [] args) {

		int port = 3010;
		int queue = 50;

		String createDBScriptPath = "bokliste.sql";
		String dbName = "pg4100innlevering2";
		String username = "root";
		String password = "";
		String serverDBName = "localhost";
		String serverDBPort = "3306";
		ServerSocket server = null;

		try {
            ConnectToDB con = ConnectToDB.getInstance();
			con.setDBConnectionParemeters(serverDBName, serverDBPort, dbName, username, password);
			con.executeScriptFromFileName(createDBScriptPath);

			if(!con.checkDBExists()){
				System.out.println("Unable to run server, database doesn't exists");
			}

			server = new ServerSocket(port, queue);
			System.out.println("Listening at port " + port);
			while( true ){
				ServerSocketThread newThread = new ServerSocketThread(server.accept(), con);
				newThread.start();
			}
		} catch (SQLException e) {
            System.out.println("Impossible to connect to database...");
        } catch (IOException e) {
			e.printStackTrace();
            System.out.println("Not possible to open the port");
        } finally {
			if(server != null)
				try {
					server.close();
				} catch (IOException e) {
					System.out.println("Error while closing the server port");
				}
		}
    }
}
