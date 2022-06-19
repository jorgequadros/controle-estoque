package Model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Model.bean.Produto;
import conection.ConnectionFactory;

public class ProdutosDAO{
	
	public void create(Produto p) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt =null;
		
		try {
			stmt = con.prepareStatement("insert into produtos1(descricao,qtde,preco) values (?,?,?)");
			stmt.setString(1, p.getDescricao());
			stmt.setInt(2, p.getQtde());
			stmt.setDouble(3, p.getValor());
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "erro ao salvar:"+e);
			
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public void update(Produto p) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt =null;
		
		try {
			stmt = con.prepareStatement("update produtos1 set descricao= ?, qtde=?, preco=? ) where id=?");
			stmt.setString(1, p.getDescricao());
			stmt.setInt(2, p.getQtde());
			stmt.setDouble(3, p.getValor());
			stmt.setInt(4, p.getId());
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "erro ao Atualizar:"+e);
			
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public List<Produto> read() throws IOException, SQLException{
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Produto> produtos = new ArrayList<>();
		try {
			stmt = con.prepareStatement("select * from produtos1");
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setQtde(rs.getInt("qtde"));
				produto.setValor(rs.getInt("preco"));
				produtos.add(produto);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			con.close();
			
			
		}
		
		return produtos;
	}

}
