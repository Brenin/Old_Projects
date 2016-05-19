package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.Album;

public class MusikkHandler {
	private ConnectToDB db;
	private Connection con;
	private String tableName = "music";
	private String format = "%-20s%-20s%-20s";
	private PreparedStatement pstmtCreate;
	private PreparedStatement pstmtReadRow;
	private PreparedStatement pstmtUpdate;
	private PreparedStatement pstmtDelete;

	public MusikkHandler() throws SQLException {
		db = new ConnectToDB();
		con = db.getConnection();
	}

	// Closes all connections
	public void close() throws SQLException {
		db.close();
		con.close();
		pstmtCreate.close();
		pstmtReadRow.close();
		pstmtUpdate.close();
		pstmtDelete.close();
	}
	
	public boolean createFromOther(Album album) throws SQLException {

		// Prepares statement
		String sql = "INSERT INTO " + tableName
				+ " (artist, song, year, genre) " + "VALUES (?,?,?,?)";
		pstmtCreate = con.prepareStatement(sql);

		// Binds values to parameters
		pstmtCreate.setString(1, album.getArtist());
		pstmtCreate.setInt(2, album.getSpor());
		pstmtCreate.setInt(3, album.getUtgitt());
		pstmtCreate.setString(4, album.getSjanger());

		// Execute SQL
		int rowsAffected = pstmtCreate.executeUpdate();
		return rowsAffected == 1;
	}

	// Insert into
	public int create(String artist, String song, int year, String genre)
			throws SQLException {

		// Prepares statement
		String sql = "INSERT INTO " + tableName
				+ " (artist, song, year, genre) " + "VALUES (?,?,?,?)";
		pstmtCreate = con.prepareStatement(sql);

		// Binds values to parameters
		pstmtCreate.setString(1, artist);
		pstmtCreate.setString(2, song);
		pstmtCreate.setInt(3, year);
		pstmtCreate.setString(4, genre);

		// Execute SQL
		int rowsAffected = pstmtCreate.executeUpdate();
		return rowsAffected;
	}

	// getRow
	public ArrayList<Album> readRows(String genre) throws SQLException {

		// Prepares Statement
		String sql = "SELECT * FROM " + tableName + " WHERE genre LIKE ?";
		pstmtReadRow = con.prepareStatement(sql);

		// Binds values to parameters
		pstmtReadRow.setString(1, genre);

		// Execute Query
		ResultSet rs = pstmtReadRow.executeQuery();

		ArrayList<Album> array = new ArrayList<Album>();
		if (rs != null) {
			// Formats the result from query, if any
			while (rs.next()) {
				Album album = new Album(rs.getString(2), rs.getString(3),
						0, rs.getInt(4), genre);
				array.add(album);
			}
		}
		return array;
	}

	// Update row
	public int updateArtist(String artist, String newArtist)
			throws SQLException {

		// Prepares Statement
		String sql = "UPDATE " + tableName + " SET artist =? WHERE artist =?";
		pstmtUpdate = con.prepareStatement(sql);

		// Binds values to parameters
		pstmtUpdate.setString(1, artist);
		pstmtUpdate.setString(2, newArtist);

		// Execute Query
		int rowsAffected = pstmtUpdate.executeUpdate();
		return rowsAffected;
	}

	public int updateAlbum(String song, String newSong) throws SQLException {
		PreparedStatement pstmtUpdate;
		// Prepares Statement
		String sql = "UPDATE " + tableName + " SET song =? WHERE song =?";
		pstmtUpdate = con.prepareStatement(sql);

		// Binds values to parameters
		pstmtUpdate.setString(1, song);
		pstmtUpdate.setString(2, newSong);

		// Execute Query
		int rowsAffected = pstmtUpdate.executeUpdate();
		return rowsAffected;
	}

	public int delete(String song) throws SQLException {

		// Prepares Statement
		String sql = "DELETE FROM " + tableName + " WHERE song =?";
		pstmtDelete = con.prepareStatement(sql);

		// Binds values to parameters
		pstmtDelete.setString(1, song);

		// Execute Query
		int rowsAffected = pstmtDelete.executeUpdate();
		return rowsAffected;
	}
}
