package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

/**
 * Created by Eirikur Lundin
 *
 *  Connect to database, works as a singleton
 */
public class ConnectToDB implements AutoCloseable {
    
    private Connection con;
    private static ConnectToDB connectToDB = null;
    private String serverName;
    private String port;
    private String databaseName;
    private String user;
    private String password;

    /**
     * This method enables you to get the singleton instance for this class
     * @return
     */
    public static ConnectToDB getInstance(){
        if(connectToDB == null){
            connectToDB = new ConnectToDB();
        }
        return connectToDB;
    }

    /**
     * Private constructor
     */
    private ConnectToDB(){}

    /**
     * Set the database parameters. *
     * @param serverName Server Name
     * @param databaseName Database Name
     * @param user UserName
     * @param password Password.
     * @throws SQLException
     */
    public void setDBConnectionParemeters(String serverName, String port, String databaseName, String user, String password) throws SQLException {
        this.serverName = serverName;
        this.port = port;
        this.databaseName = databaseName;
        this.user = user;
        this.password = password;
    }

    /**
     * Starts the database connection using the defined parameters
     * @throws SQLException
     */
    public void startDBConnection() throws SQLException{
        if(con == null){
            con = DriverManager.getConnection("jdbc:mysql://" + serverName + ":"+ port +"/"+databaseName, user, password);
        }
    }

    /**
     * Connects using the provided parameters and verifies if the database name exists
     * @return
     */
    public boolean checkDBExists(){
        try{
            System.out.println("Creating a connection...");
            Connection conn = DriverManager.getConnection("jdbc:mysql://" + serverName + ":"+ port +"/", user, password);

            ResultSet resultSet = conn.getMetaData().getCatalogs();

            while (resultSet.next()) {
                String databaseName = resultSet.getString(1);
                if(databaseName.equals(this.databaseName)){
                    return true;
                }
            }
            resultSet.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Closes the database connections
     * @throws SQLException
     */
    public void close() throws SQLException {
        con.close();
    }

    /**
     * Returns the current database connection;
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        if(con == null)
            startDBConnection();
        return con;
    }

    /**
     * Executes an sql script file using the parameters to create a database connection
     * @param scriptFileName
     * @throws SQLException
     * @throws IOException
     */
    public void executeScriptFromFileName(String scriptFileName) throws SQLException, IOException {
        Connection con = DriverManager.getConnection("jdbc:mysql://" + serverName + ":"+ port +"/", user, password);
        ScriptRunner runner = new ScriptRunner(con, false, true);
        runner.runScript(new BufferedReader(new FileReader(scriptFileName)));
    }
}

