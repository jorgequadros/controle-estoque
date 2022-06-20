package modulo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO{

	
	public FornecedorDAO() {	}
	
	public void inserirRegistro(Fornecedor f) throws IOException, SQLException {
		
		ConexaoBD.getInstance();
		Connection conexao = ConexaoBD.getConexao();
		String sql = "INSERT INTO fornecedor (nome, endereco, cidade, bairro, UF,cep) values(?,?,?,?,?,?)";
		PreparedStatement stmt1 = conexao.prepareStatement(sql);
		stmt1.setString(1, f.getRazaoSocial());
		stmt1.setString(2, f.getEndereco());
		stmt1.setString(3, f.getCidade());
		stmt1.setString(4, f.getBairro());
		stmt1.setString(5, f.getUf());
		stmt1.setString(6, f.getCep());
		stmt1.execute();
		stmt1.close();
		
	}
	
	public void updateRegistro(Fornecedor f) throws IOException, SQLException {
		ConexaoBD.getInstance();
		Connection conexao = ConexaoBD.getConexao();
		String sql = "UPDATE fornecedor SET nome = ?, endereco = ?, cidade = ?, bairro = ?, UF = ?,cep = ? where id = ?";
		PreparedStatement stmt1 = conexao.prepareStatement(sql);
		stmt1.setString(1, f.getRazaoSocial());
		stmt1.setString(2, f.getEndereco());
		stmt1.setString(3, f.getCidade());
		stmt1.setString(4, f.getBairro());
		stmt1.setString(5, f.getUf());
		stmt1.setString(6, f.getCep());
		stmt1.setInt(7, f.getId());
		stmt1.execute();
		stmt1.close();
	}
	
	public void deleteRegistro(Fornecedor f) throws IOException {
		ConexaoBD.getInstance();
		Connection conexao = ConexaoBD.getConexao();
		String sql = "DELETE  from fornecedor where id = ?";
		
		
		try {
			PreparedStatement stmt1 = conexao.prepareStatement(sql);
			stmt1.setInt(1, f.getId());
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
