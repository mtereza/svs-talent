package conn;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class LibraryConnection {
	
	public static Connection getConnection() throws SQLException{
		Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/library", "postgres", "postgres");
		return connection;
	}
	
	public void closeConnection(Connection connection) throws SQLException{
		connection.close();
	}

}
