package tk.leooresende.stateful.infra.util.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDBFatory {
	private static Connection connection;
	private static final String DB_USERNAME = "DB_USERNAME";
	private static final String DB_PASSWORD = "DB_PASSWORD";
	
	static {
		ConnectionDBFatory.createConnection();
		
	}
	
	private static void createConnection() {
		try {
			ConnectionDBFatory.connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/teste", 
							System.getenv(ConnectionDBFatory.DB_USERNAME), 
							System.getenv(ConnectionDBFatory.DB_PASSWORD));
			ConnectionDBFatory.connection.setAutoCommit(false);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnection() {
		if (ConnectionDBFatory.connection == null) ConnectionDBFatory.createConnection();
		return ConnectionDBFatory.connection;
	}
}
