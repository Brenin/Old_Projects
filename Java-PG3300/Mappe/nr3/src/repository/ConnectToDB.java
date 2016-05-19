package repository;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectToDB implements AutoCloseable {

	private DataSource ds;
	private Context ctx;
	private Connection con;

	public ConnectToDB() throws SQLException {
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
			con = ds.getConnection();
		} catch (NamingException ne) {
			throw new RuntimeException(ne);
		}
	}

	public void close() throws SQLException {
		con.close();
	}

	public Connection getConnection() {
		return con;
	}
}