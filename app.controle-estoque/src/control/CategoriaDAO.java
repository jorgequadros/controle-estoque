package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoriaDAO extends Categoria{
	private static CategoriaDAO instance =null;
	
	public static CategoriaDAO getInstance() {
		if(instance == null) {
			instance = new CategoriaDAO();
		};
		return instance;
	}

	public CategoriaDAO() {
		try {
			ConexaoBD.getInstance();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void inserirRegistro(String descricao) throws IOException, SQLException {
		
		Connection conexao = ConexaoBD.getConexao();
		String sql = "INSERT INTO categorias (descricao) values(?)";
		PreparedStatement stmt1 = conexao.prepareStatement(sql);
		stmt1.setString(1, descricao);
		stmt1.execute();
		stmt1.close();
		
	}
	
	public void updateRegistro(String descricao, String id) throws IOException, SQLException {

		Connection conexao = ConexaoBD.getConexao();
		String sql = "UPDATE categorias SET descricao = ? where id = ?";
		PreparedStatement stmt1 = conexao.prepareStatement(sql);
		stmt1.setString(1, descricao);
		stmt1.setString(2, id);
		stmt1.execute();
		stmt1.close();
		
	}
	
	public void deleteRegistro(String id) throws IOException {
		ConexaoBD.getInstance();
		Connection conexao = ConexaoBD.getConexao();
		String sql = "DELETE  from categorias where id = ?";
		
		
		try {
			PreparedStatement stmt1 = conexao.prepareStatement(sql);
			stmt1.setString(1, id);
			stmt1.execute();
			stmt1.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
