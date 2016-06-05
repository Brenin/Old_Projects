package quiz;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.ConnectToDB;

/**
 * Created by Eirikur Lundin
 *
 * This class defines a Question, it contains all the question and answer fields making it a data link with the database.
 */
public class Question{
    
	/**
     * Question fields
     */
    private String writer;
    private String title;
    private String ISBN;
    private int pages;
    private int published;

    /**
     * Constructor
     */
    public Question() {
    }

    /**
     * Regular Constructor *
     * @param writer Author
     * @param title Title
     * @param ISBN ISBN
     * @param pages Amount of Page
     * @param published Year
     */
    public Question(String writer, String title, String ISBN, int pages, int published) {
        this.writer = writer;
        this.title = title;
        this.ISBN = ISBN;
        this.pages = pages;
        this.published = published;
    }

    /**
     * Returns the writer field
     * @return
     */
    public String getForfatter() {
        return writer;
    }

    /**
     * Returns the title field
     * @return
     */
    public String getTittel() {
        return title;
    }

    /**
     * Returns the ISBN field
     * @return
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Returns the pages field
     * @return
     */
    public int getSider() {
        return pages;
    }

    /**
     * Returns the published field
     * @return
     */
    public int getUtgitt() {
        return published;
    }

    /**
     * Returns the questions from the database *
     * @param database Database connection.
     * @return Questions available.
     */
    public Question[] getInstances(ConnectToDB database) {
        PreparedStatement preStatement = null;
        try {
            preStatement = database.getConnection().prepareStatement("SELECT forfatter, tittel, ISBN, sider, utgitt FROM bokliste");
            ResultSet resultSet = preStatement.executeQuery();
            List<Question> answer = new ArrayList<Question>();

            while (resultSet.next()){
                Question newItem = new Question(
                    resultSet.getString("forfatter"),
                    resultSet.getString("tittel"),
                    resultSet.getString("ISBN"),
                    resultSet.getInt("sider"),
                    resultSet.getInt("utgitt")
                );
                answer.add(newItem);
            }

            return answer.toArray(new Question[1]);
        }catch (Exception e){
            return null;
        }finally {
            if ( preStatement != null ){
                try {
                    preStatement.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Returns a string representation of the object
     * @return
     */
    @Override
    public String toString() {
        return "QUESTION" +
            writer +
            "####" + title +
            "####" + ISBN +
            "####" + pages +
            "####" + published;
    }
}
