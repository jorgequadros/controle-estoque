package conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String URL="jdbc:mysql://localhost/estoque?characterEncoding=utf-8&verifyServerCertificate=false&useSSL=true";
	private static final String USER="root";
	private static final String PASS="Sql105899@";
	
	public static Connection getConnection() {
		
		
		try {
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro na conexão: ",e);
		}
	}
	
	
	public static void closeConnection(Connection con) {
			try {
				if(con!=null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	public static void closeConnection(Connection con, PreparedStatement stmt) {
		
		closeConnection(con);
		
		try {
			if(stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		closeConnection(con,stmt);
		try {
			if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
