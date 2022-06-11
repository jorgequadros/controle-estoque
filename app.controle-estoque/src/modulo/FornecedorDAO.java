package modulo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO{

	private static FornecedorDAO instance =null;
	
	public FornecedorDAO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public static FornecedorDAO getInstance() {
		if(instance == null) {
			instance = new FornecedorDAO();
		};
		return instance;
	}
	

	public void inserirRegistro(String nome, String endereco, String cidade, String bairro, int UF, String cep) throws IOException, SQLException {
		
		ConexaoBD.getInstance();
		Connection conexao = ConexaoBD.getConexao();
		String sql = "INSERT INTO fornecedor (nome, endereco, cidade, bairro, UF,cep) values(?,?,?,?,?,?)";
		PreparedStatement stmt1 = conexao.prepareStatement(sql);
		stmt1.setString(1, nome);
		stmt1.setString(2, endereco);
		stmt1.setString(3, cidade);
		stmt1.setString(4, bairro);
		stmt1.setInt(5, UF);
		stmt1.setString(6, cep);
		stmt1.execute();
		stmt1.close();
		
	}
	
	public void updateRegistro(String nome, String endereco, String cidade, String bairro, int UF, String cep, String id) throws IOException, SQLException {
		ConexaoBD.getInstance();
		Connection conexao = ConexaoBD.getConexao();
		String sql = "UPDATE fornecedor SET nome = ?, endereco = ?, cidade = ?, bairro = ?, UF = ?,cep = ? where id = ?";
		PreparedStatement stmt1 = conexao.prepareStatement(sql);
		stmt1.setString(1, nome);
		stmt1.setString(2, endereco);
		stmt1.setString(3, cidade);
		stmt1.setString(4, bairro);
		stmt1.setInt(5, UF);
		stmt1.setString(6, cep);
		stmt1.setString(7, id);
		stmt1.execute();
		stmt1.close();
	}
	
	public void deleteRegistro(String id) throws IOException {
		ConexaoBD.getInstance();
		Connection conexao = ConexaoBD.getConexao();
		String sql = "DELETE  from fornecedor where id = ?";
		
		
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

	public List<Fornecedor> obterFornecedor() throws SQLException{
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		
		try {
			ConexaoBD.getInstance();
			Connection con = ConexaoBD.getConexao();
			PreparedStatement stmt = con.prepareStatement("select f.id, f.nome, f.endereco, f.cidade, f.bairro, u.uf, f.cep  from fornecedor as f join uf as u on u.id=f.UF;");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Fornecedor f = new Fornecedor();
				f.setId(rs.getInt("f.id"));
				f.setRazaoSocial(rs.getString("f.nome"));
				f.setEndereco(rs.getString("f.endereco"));
				f.setCidade(rs.getString("f.cidade"));
				f.setBairro(rs.getString("f.bairro"));
				f.setUf(rs.getString("u.uf"));
				f.setCep(rs.getString("f.cep"));
				fornecedores.add(f);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fornecedores;
	}
	
	public List<Fornecedor> obterFornecedorNome(String descricao) throws SQLException{
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		
		try {
			ConexaoBD.getInstance();
			Connection con = ConexaoBD.getConexao();
			PreparedStatement stmt = con.prepareStatement("select f.id, f.nome, f.endereco, f.cidade, f.bairro, u.uf, f.cep  from fornecedor as f join uf as u on u.id=f.UF where descricao like ?;");
			stmt.setString(1, descricao);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Fornecedor c =new Fornecedor();
				c.setId(rs.getInt("f.id"));
				c.setRazaoSocial(rs.getString("f.nome"));
				c.setEndereco(rs.getString("f.endereco"));
				c.setCidade(rs.getString("f.cidade"));
				c.setBairro(rs.getString("f.bairro"));
				c.setUf(rs.getString("u.uf"));
				c.setCep(rs.getString("f.cep"));
				fornecedores.add(c);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fornecedores;
	}

}
