package conection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionFactory {
	private final String DRIVE = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost/estoque?characterEncoding=utf-8&verifyServerCertificate=false&useSSL=true";
	private final String USER = "root";
	private final String PASS ="Sql105899@";
	
	public Connection getConnection() throws SQLException {
		try {
			Class.forName(DRIVE);
			return (Connection) DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException| SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("[ERRO] Erro de conexão : "+e);
		}
		
	}
}
