package br.com.healthtrack.singleton;
import java.sql.Connection;
import java.sql.DriverManager;

public class HealthTrackDBManager {

	private static HealthTrackDBManager connectionManager;
	
	private HealthTrackDBManager() {
	}

	public static HealthTrackDBManager getInstance() {
		if (connectionManager == null) {
			connectionManager = new HealthTrackDBManager();
		}
		return connectionManager;
	}
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:SYSTEM/SYSTEM@localhost:1521:XE","SYSTEM", "nicolas");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}