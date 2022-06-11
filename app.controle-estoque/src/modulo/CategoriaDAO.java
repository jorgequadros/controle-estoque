package modulo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class CategoriaDAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static CategoriaDAO instance =null;
	private String[] colunas = {"ID", "Descrição"};
	private List<Categoria> dados = new ArrayList<>();
	
	
	public static CategoriaDAO getInstance() throws SQLException {
		if(instance == null) {
			instance = new CategoriaDAO();
		};
		return instance;
	}

	public CategoriaDAO() throws SQLException {
		try {
			ConexaoBD.getInstance();
			obterCategoria();
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
	
	public void obterCategoria() throws SQLException{
		
		
		try {
			ConexaoBD.getInstance();
			Connection con = ConexaoBD.getConexao();
			PreparedStatement stmt = con.prepareStatement("select * Descrição from categorias;");
			ResultSet rs = stmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int numCols = rsmd.getColumnCount();
			colunas = new String[numCols];
			//while(rs.next()) {}
			
			
			/*
			 * linhas.clear(); for(int i=0;i<numCols;i++) {
			 * colunas[i]=rsmd.getColumnName(i+1); }; while (rs.next()) { Object l[] = new
			 * Object[numCols]; for(int i=0;i<numCols;i++) {l[i] = rs.getObject(i+1);};
			 * dados.add(l); } fireTableDataChanged();
			 */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
