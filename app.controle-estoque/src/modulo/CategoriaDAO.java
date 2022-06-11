package modulo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
	
	private static CategoriaDAO instance =null;

	public static CategoriaDAO getInstance() throws SQLException {
		if(instance == null) {
			instance = new CategoriaDAO();
		};
		return instance;
	}

	public CategoriaDAO() throws SQLException {
		try {
			ConexaoBD.getInstance();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void inserirRegistro(String descricao) throws IOException, SQLException {
		if(!descricao.isEmpty() || descricao!=null) {
			Connection conexao = ConexaoBD.getConexao();
			String sql = "INSERT INTO categoria (descricao) values(?)";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, descricao);
			stmt.execute();
			stmt.close();
		}
		
	}
	
	public void updateRegistro(String descricao, String id) throws IOException, SQLException {

		Connection conexao = ConexaoBD.getConexao();
		String sql = "UPDATE categorias SET descricao = ? where id = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, descricao);
		stmt.setString(2, id);
		stmt.execute();
		stmt.close();
		
	}
	
	public void deleteRegistro(String id) throws IOException {
		ConexaoBD.getInstance();
		Connection conexao = ConexaoBD.getConexao();
		String sql = "DELETE  from categorias where id = ?";
		
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Categoria> obterCategoria() throws SQLException{
		
		List<Categoria> categorias = new ArrayList<>();
		
		try {
			ConexaoBD.getInstance();
			Connection con = ConexaoBD.getConexao();
			PreparedStatement stmt = con.prepareStatement("select * from categorias;");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Categoria c = new Categoria();
				c.setId(rs.getInt("id"));
				c.setDescricao(rs.getString("Descricao"));
				categorias.add(c);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return categorias;

	}
}
