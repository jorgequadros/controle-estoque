package conection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoBD {
	private static ConexaoBD instance = null;
	private static Connection connection = null;
	private static int clients = 0;
	
	private ConexaoBD() throws IOException {
		try {
			Properties prop = getProperties();
			final String url = prop.getProperty("banco.url");
			final String usuario = prop.getProperty("banco.usuario");
			final String senha = prop.getProperty("banco.senha");
			
			if(usuario.length() != 0) {
				connection = DriverManager.getConnection(url, usuario, senha);
			}else { 
				connection = DriverManager.getConnection(url);
			}
			System.out.println("ConexãoDB[conexao OK]");
		} catch (IOException | SQLException e) {
			System.err.println(e);
		}
	}
	
	public static ConexaoBD getInstance() throws IOException {
		if (instance == null) {
			instance = new ConexaoBD();
		}
		return instance;
	}
	
	public static Connection getConexao() throws IOException {
		
		try {
			if (connection == null) {
				throw new RuntimeException("connection==null");
			}
			clients++;
			System.out.println("ConexãoDB[conexao cliente]");
			return connection;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public void desligar() {
		System.out.println("ConexãoDB[Desliga cliente]");
		clients--;
		if (clients > 0) {
			return;
		}
		try {
			connection.close();
			instance = null;
			connection = null;
			System.out.println("ConexãoDB[conexao fechada]");
		} catch (SQLException sqle) {
			System.err.println(sqle);
		}
	}

	private static Properties getProperties() throws IOException{
		Properties prop = new Properties();
		String caminho = "bd.properties";
		prop.load(ConexaoBD.class.getResourceAsStream(caminho));
		return prop;
	}
}
