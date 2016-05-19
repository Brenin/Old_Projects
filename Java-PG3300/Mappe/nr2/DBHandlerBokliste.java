// Created by Eirikur Lundin
// Koden som ligger kommenterad i metoderna är det sättet jag helst ville gjort det på

package nr2;

import java.sql.*;
import java.util.*;
import db.ConnectToDB;

public class DBHandlerBokliste {

	private ConnectToDB db;
	private Connection con;
	private String tableName = "bokliste";
	private String format = "%-20s%-20s%-20s";
	private PreparedStatement pstmtUpdateTittel;
	private PreparedStatement pstmtUpdateForfatter;
	private PreparedStatement pstmtDeleteForfatter;
	private PreparedStatement pstmtDeleteTittel;
	private PreparedStatement pstmtInsertRow;
	private PreparedStatement pstmtGetTable;
	private PreparedStatement pstmtGetRow;

	public DBHandlerBokliste(String user, String password) throws SQLException {
		db = new ConnectToDB(user, password);
		con = db.getConnection();

		// Prepare Statements
		pstmtUpdateTittel 		= con.prepareStatement("UPDATE " + tableName + " SET TITTEL = ? WHERE TITTEL = ?");
		pstmtUpdateForfatter 	= con.prepareStatement("UPDATE " + tableName + " SET FORFATTER = ? WHERE FORFATTER = ?");
		pstmtDeleteForfatter 	= con.prepareStatement("DELETE FROM " + tableName + " WHERE FORFATTER = ?");
		pstmtDeleteTittel 		= con.prepareStatement("DELETE FROM " + tableName + " WHERE TITTEL = ?");
		pstmtInsertRow 			= con.prepareStatement("INSERT INTO " + tableName + " VALUES (?, ?, ?)");
		pstmtGetTable 			= con.prepareStatement("SELECT * FROM " + tableName);
		pstmtGetRow 			= con.prepareStatement("SELECT * FROM " + tableName + " WHERE FORFATTER = ? AND TITTEL = ?");
	}

	public void close() throws SQLException {
		db.close();
		con.close();
		pstmtUpdateTittel.close();
		pstmtUpdateForfatter.close();
		pstmtDeleteForfatter.close();
		pstmtDeleteTittel.close();
		pstmtInsertRow.close();
		pstmtGetTable.close();
		pstmtGetRow.close();
	}

	public int updateTittel(String tittel, String nyTittel) throws SQLException {

		// Prepares Statement
		// String sql = "UPDATE " + tableName + " SET TITTEL = ? WHERE TITTEL = ?";
		// pstmtUpdateTittel = con.prepareStatement(sql);

		// Binds values to parameters
		pstmtUpdateTittel.setString(1, nyTittel);
		pstmtUpdateTittel.setString(2, tittel);

		// Execute SQL
		int rowsAffected = pstmtUpdateTittel.executeUpdate();
		// pstmtUpdateTittel.close();
		return rowsAffected;
	}

	public int updateForfatter(String forfatter, String nyForfatter) throws SQLException {

		// Prepares Statement
		// String sql = "UPDATE " + tableName + " SET FORFATTER = ? WHERE FORFATTER = ?";
		// pstmtUpdateForfatter = con.prepareStatement(sql);

		// Binds values to parameters
		pstmtUpdateForfatter.setString(1, nyForfatter);
		pstmtUpdateForfatter.setString(2, forfatter);

		// Execute SQL
		int rowsAffected = pstmtUpdateForfatter.executeUpdate();
		// pstmtUpdateForfatter.close();
		return rowsAffected;
	}

	public int deleteForfatter(String forfatter) throws SQLException {

		// Prepares Statement
		// String sql = "DELETE FROM " + tableName + " WHERE FORFATTER = ?";
		// pstmtDeleteForfatter = con.prepareStatement(sql);

		// Binds values to parameters
		pstmtDeleteForfatter.setString(1, forfatter);

		// Execute SQL
		int rowsAffected = pstmtDeleteForfatter.executeUpdate();
		// pstmtDeleteForfatter.close();
		return rowsAffected;
	}

	public int deleteTittel(String tittel) throws SQLException {

		// Prepares Statement
		// String sql = "DELETE FROM " + tableName + " WHERE TITTEL = ?";
		// pstmtDeleteTittel = con.prepareStatement(sql);

		// Binds values to parameters
		pstmtDeleteTittel.setString(1, tittel);

		// Execute SQL
		int rowsAffected = pstmtDeleteTittel.executeUpdate();
		// pstmtDeleteTittel.close();
		return rowsAffected;
	}

	public int insertRow(String isbn, String forfatter, String tittel) throws SQLException {

		// Prepares Statement
		// String sql = "INSERT INTO " + tableName + " VALUES (?, ?, ?)";
		// pstmtInsertRow = con.prepareStatement(sql);

		// Binds values to parameters
		pstmtInsertRow.setString(1, isbn);
		pstmtInsertRow.setString(2, forfatter);
		pstmtInsertRow.setString(3, tittel);

		// Execute SQL
		int rowsAffected = pstmtInsertRow.executeUpdate();
		// pstmtInsertRow.close();
		return rowsAffected;
	}

	public ArrayList<String> getTable() throws SQLException {

		// Prepares Statement
		// String sql = "SELECT * FROM " + tableName;
		// pstmtGetTable = con.prepareStatement(sql);

		// Execute SQL
		ResultSet rs = pstmtGetTable.executeQuery();

		ArrayList<String> array = new ArrayList<String>();
		if (rs != null) {
			array.add(String.format(format, "ISBN", "Författare", "Titel"));

			while (rs.next()) {
				array.add(String.format(format, rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		}
		// pstmtGetTable.close();
		return array;
	}

	public String getRow(String forfatter, String tittel) throws SQLException {

		// Prepares Statement
		// String sql = "SELECT * FROM " + tableName + " WHERE FORFATTER = ? AND TITTEL = ?";
		// pstmtGetRow = con.prepareStatement(sql);

		// Binds values to parameters
		pstmtGetRow.setString(1, forfatter);
		pstmtGetRow.setString(2, tittel);

		// Execute SQL
		ResultSet rs = pstmtGetRow.executeQuery();

		rs.first();

		String row = "";
		if (rs != null) {
			row = String.format(format, rs.getString(2), rs.getString(3), rs.getString(4));
		}
		// pstmtGetRow.close();
		return row;
	}

}