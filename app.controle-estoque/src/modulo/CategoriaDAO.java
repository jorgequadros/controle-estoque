package modulo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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

	public void inserirRegistro(Categoria c) throws IOException, SQLException {
		if(!c.getDescricao().isEmpty() || c.getDescricao()!=null) {
			Connection conexao = ConexaoBD.getConexao();
			String sql = "INSERT INTO categoria (descricao) values(?)";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, c.getDescricao());
			stmt.execute();
			stmt.close();
			
		}
		
	}
	
	public void updateRegistro(Categoria c) throws SQLException {

		Connection conexao = null;
		try {
			conexao = ConexaoBD.getConexao();
			String sql = "UPDATE categorias SET descricao = ? where id = ?";
			PreparedStatement stmt;
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, c.getDescricao());
			stmt.setInt(2, c.getId());
			stmt.execute();
			stmt.close();
			
			JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "[ERRO]Erro ao Atualizar!" + e);
			
		}
		
	
		
	}
	
	public void deleteRegistro(Categoria c) throws IOException {
		ConexaoBD.getInstance();
		Connection conexao = ConexaoBD.getConexao();
		String sql = "DELETE  from categorias where id = ?";
		
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, c.getId());
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
	
	public List<Categoria> obterCategoriaDescricao(String desc) throws SQLException{
		
		List<Categoria> categorias = new ArrayList<>();
		
		try {
			ConexaoBD.getInstance();
			Connection con = ConexaoBD.getConexao();
			PreparedStatement stmt = con.prepareStatement("select * from categorias where descricao like ?;");
			stmt.setString(1, desc+'%');
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
